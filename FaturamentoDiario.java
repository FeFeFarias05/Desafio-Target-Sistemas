
import java.util.List;
import java.util.ArrayList;

public class FaturamentoDiario {
    private int dia;
    private double valor;

    public FaturamentoDiario(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Dia: " + dia + ", Valor: " + valor;
    }

}
