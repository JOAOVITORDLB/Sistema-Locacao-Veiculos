
package folder;

class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;

    public Cliente(int id, String nome, String cpf, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone + ", Endereço: " + endereco;
    }
}
