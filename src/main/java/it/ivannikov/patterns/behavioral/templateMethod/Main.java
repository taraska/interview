package it.ivannikov.patterns.behavioral.templateMethod;

/*
Определение: Определяет скелет алгоритма, оставляя некоторые шаги подклассам.
Пример: Генерация отчетов (HTML, PDF).
* */
abstract class ReportGenerator {
    public final void generateReport() {
        collectData();
        formatReport();
        printReport();
    }

    protected abstract void formatReport();

    private void collectData() {
        System.out.println("Сбор данных...");
    }

    private void printReport() {
        System.out.println("Печать отчета...");
    }
}

class HtmlReportGenerator extends ReportGenerator {
    @Override
    protected void formatReport() {
        System.out.println("Форматирование в HTML");
    }
}


public class Main {
    public static void main(String[] args) {
        // Использование:
        ReportGenerator generator = new HtmlReportGenerator();
        generator.generateReport();
    }
}
