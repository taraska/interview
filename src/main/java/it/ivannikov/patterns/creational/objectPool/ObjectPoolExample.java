package it.ivannikov.patterns.creational.objectPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

//Управляет набором заранее созданных объектов для повторного использования.
// Объект, который будет храниться в пуле
class DatabaseConnection {
    private static int counter = 0;
    private final int id;

    public DatabaseConnection() {
        this.id = ++counter;
    }

    public void query(String sql) {
        System.out.println("Connection " + id + " executing: " + sql);
    }
}

// Пул объектов
class ConnectionPool {
    private final BlockingQueue<DatabaseConnection> pool;
    private final int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new LinkedBlockingQueue<>(maxSize);
        initializePool();
    }

    private void initializePool() {
        for (int i = 0; i < maxSize; i++) {
            pool.offer(new DatabaseConnection());
        }
    }

    public DatabaseConnection getConnection() throws InterruptedException {
        return pool.take(); // Блокирует, если пул пуст
    }

    public void releaseConnection(DatabaseConnection connection) {
        pool.offer(connection); // Возвращает объект в пул
    }
}

// Пример использования
public class ObjectPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ConnectionPool pool = new ConnectionPool(3);

        // Получаем соединения из пула
        DatabaseConnection conn1 = pool.getConnection();
        DatabaseConnection conn2 = pool.getConnection();
        DatabaseConnection conn3 = pool.getConnection();

        conn1.query("SELECT * FROM users");
        conn2.query("UPDATE accounts SET balance = 100");

        // Возвращаем соединения в пул
        pool.releaseConnection(conn1);
        pool.releaseConnection(conn2);

        // Новый запрос с переиспользованным соединением
        DatabaseConnection conn4 = pool.getConnection();
        conn4.query("DELETE FROM logs");
    }
}
