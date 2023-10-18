import java.util.ArrayList;
import java.util.List;

// Interface para observadores
interface Observer {
    void update(Cell cell);
}

// Classe que representa uma célula na planilha
class Cell {
    private String name;
    private int value;
    private List<Observer> observers;

    public Cell(String name) {
        this.name = name;
        this.value = 0;
        this.observers = new ArrayList<>();
    }

    public void setValue(int value) {
        if (this.value != value) {
            this.value = value;
            notifyObservers();
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}

// Classe que implementa um observador específico para atualizar células dependentes
class DependencyObserver implements Observer {
    private Cell cell;

    public DependencyObserver(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void update(Cell changedCell) {
        // Quando uma célula é alterada, atualiza a célula dependente
        if (cell.getName().equals("A3")) {
            Cell a1 = Spreadsheet.getCell("A1");
            Cell a2 = Spreadsheet.getCell("A2");
            cell.setValue(a1.getValue() + a2.getValue());
        }
    }
}

// Classe que representa a planilha
class Spreadsheet {
    private static List<Cell> cells = new ArrayList<>();

    public static Cell createCell(String name) {
        Cell cell = new Cell(name);
        cells.add(cell);
        return cell;
    }

    public static Cell getCell(String name) {
        for (Cell cell : cells) {
            if (cell.getName().equals(name)) {
                return cell;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Spreadsheet.createCell("A1");
        Spreadsheet.createCell("A2");
        Cell a3 = Spreadsheet.createCell("A3");

        a3.addObserver(new DependencyObserver(a3));

        // Alterando o valor de A1 e A2 (isso disparará a atualização de A3)
        Spreadsheet.getCell("A1").setValue(10);
        Spreadsheet.getCell("A2").setValue(20);

        // Verificando o valor de A3 após as atualizações
        System.out.println("Valor de A3: " + Spreadsheet.getCell("A3").getValue());
    }
}
