package Elektro.DB.registros;
import java.util.Random;

public class RegistrosDTO {
    private String Nome_cliente,
            Email, Contrato, Corte, Endereco_rua, Bairro_nome, Etapa, Cidade, Estado, Tarifa, Municipio, Classe_principal,
            Localiza, Id_inscricao, Equipamento_codigo, Protocolo;
    private int Id_cliente, Documento, RG, Telefone, Celular, UC, Cep, Local, NIS, CNPJ_uc, Foto_url;
    private float Fatura, Total_fatura;

    Random rand = new Random();

    int idCliente = 100000 + rand.nextInt(999999);
    int idFunc = 100000 + rand.nextInt(999999);
    int idRandom = 1000 + rand.nextInt(9999);


    public RegistrosDTO() {
        this.Nome_cliente = "";
        this.Email = "";
        this.Contrato = "";
        this.Corte = "";
        this.Endereco_rua = "";
        this.Bairro_nome = "";
        this.Etapa = "";
        this.Cidade = "";
        this.Estado = "";
        this.Tarifa = "";
        this.Classe_principal = "";
        this.Localiza = "";
        this.Id_inscricao = "";
        this.Equipamento_codigo = "";
        this.Protocolo = "";
        this.Telefone = this.Celular = this.UC = this.Cep = this.Local = this.NIS = this.CNPJ_uc = this.Foto_url = 0;
        this.Fatura = this.Total_fatura = 0.F;
    }
    public String getNome_cliente() {
        return Nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        Nome_cliente = nome_cliente;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String contrato) {
        Contrato = contrato;
    }

    public String getCorte() {
        return Corte;
    }

    public void setCorte(String corte) {
        Corte = corte;
    }

    public String getEndereco_rua() {
        return Endereco_rua;
    }

    public void setEndereco_rua(String endereco_rua) {
        Endereco_rua = endereco_rua;
    }

    public String getBairro_nome() {
        return Bairro_nome;
    }

    public void setBairro_nome(String bairro_nome) {
        Bairro_nome = bairro_nome;
    }

    public String getEtapa() {
        return Etapa;
    }

    public void setEtapa(String etapa) {
        Etapa = etapa;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTarifa() {
        return Tarifa;
    }

    public void setTarifa(String tarifa) {
        Tarifa = tarifa;
    }

    public String getClasse_principal() {
        return Classe_principal;
    }

    public void setClasse_principal(String classe_principal) {
        Classe_principal = classe_principal;
    }

    public String getLocaliza() {
        return Localiza;
    }

    public void setLocaliza(String localiza) {
        Localiza = localiza;
    }

    public String getId_inscricao() {
        return Id_inscricao;
    }

    public void setId_inscricao(String id_inscricao) {
        Id_inscricao = id_inscricao;
    }

    public float getFatura() {
        return Fatura;
    }

    public void setFatura(float fatura) {
        Fatura = fatura;
    }

    public String getEquipamento_codigo() {
        return Equipamento_codigo;
    }

    public void setEquipamento_codigo(String equipamento_codigo) {
        Equipamento_codigo = equipamento_codigo;
    }

    public String getProtocolo() {
        return Protocolo;
    }

    public void setProtocolo(String protocolo) {
        Protocolo = protocolo;
    }

    public int getId_cliente() {
        return idCliente;
    }

    public int getId_func() {
        return idFunc;
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int documento) {
        Documento = documento;
    }

    public int getRG() {
        return RG;
    }

    public void setRG(int rG) {
        RG = rG;
    }

    public int getTelefone() {
        return Telefone;
    }

    public void setTelefone(int telefone) {
        Telefone = telefone;
    }

    public int getCelular() {
        return Celular;
    }

    public void setCelular(int celular) {
        Celular = celular;
    }

    public int getUC() {
        return UC;
    }

    public void setUC(int uC) {
        UC = uC;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int cep) {
        Cep = cep;
    }

    public int getLocal() {
        return Local;
    }

    public void setLocal(int local) {
        Local = local;
    }

    public int getNIS() {
        return NIS;
    }

    public void setNIS(int nIS) {
        NIS = nIS;
    }

    public int getCNPJ_uc() {
        return CNPJ_uc;
    }

    public void setCNPJ_uc(int cNPJ_uc) {
        CNPJ_uc = cNPJ_uc;
    }

    public int getFoto_url() {
        return Foto_url;
    }

    public void setFoto_url(int foto_url) {
        Foto_url = foto_url;
    }

    public float getTotal_fatura() {
        return Total_fatura;
    }

    public void setTotal_fatura(float total_fatura) {
        Total_fatura = total_fatura;
    }

    public void setId_cliente(int id_cliente) {
        Id_cliente = id_cliente;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }
}