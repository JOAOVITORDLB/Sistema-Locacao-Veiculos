
package folder;

class Veiculo {
    private int id;
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private boolean disponivel;

    public Veiculo(int id, String marca, String modelo, int ano, String placa, boolean disponivel) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Placa: " + placa + ", Disponível: " + disponivel;
    }
}
