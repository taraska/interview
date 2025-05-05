package it.ivannikov.patterns.behavioral.interpreter;

//Используется для определения грамматики и интерпретации выражений.
import java.util.Map;

// Абстрактное выражение
interface Expression {
    int interpret(Map<String, Integer> context);
}

// Терминальное выражение (переменная)
class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return context.getOrDefault(name, 0);
    }
}

// Нетерминальное выражение (сложение)
class Add implements Expression {
    private final Expression left;
    private final Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Пример использования
public class InterpreterExample {
    public static void main(String[] args) {
        // Выражение: x + y
        Expression expression = new Add(
            new Variable("x"),
            new Variable("y")
        );

        // Контекст (значения переменных)
        Map<String, Integer> context = Map.of("x", 10, "y", 5);

        // Интерпретация
        int result = expression.interpret(context);
        System.out.println("Result: " + result); // 15
    }
}
