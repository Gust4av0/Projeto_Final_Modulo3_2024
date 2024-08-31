package modelo;

public class Objeto {

    /**São os mesmos dados que tem na tabela do banco de dados*/
    private Integer idObjeto;
    private Integer idCena;
    private String nomeObjeto;
    private String descricaoObjeto;
    private String resultadoPositivo;
    private String resultadoNegativo;
    private String comandoCorreto;
    private Integer proximaCena;
    private Boolean podeCarregar;

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Integer getIdCena() {
        return idCena;
    }

    public void setIdCena(Integer idCena) {
        this.idCena = idCena;
    }

    public String getNomeObjeto() {
        return nomeObjeto;
    }

    public void setNomeObjeto(String nomeObjeto) {
        this.nomeObjeto = nomeObjeto;
    }

    public String getDescricaoObjeto() {
        return descricaoObjeto;
    }

    public void setDescricaoObjeto(String descricaoObjeto) {
        this.descricaoObjeto = descricaoObjeto;
    }

    public String getResultadoPositivo() {
        return resultadoPositivo;
    }

    public void setResultadoPositivo(String resultadoPositivo) {
        this.resultadoPositivo = resultadoPositivo;
    }

    public String getResultadoNegativo() {
        return resultadoNegativo;
    }

    public void setResultadoNegativo(String resultadoNegativo) {
        this.resultadoNegativo = resultadoNegativo;
    }

    public String getComandoCorreto() {
        return comandoCorreto;
    }

    public void setComandoCorreto(String comandoCorreto) {
        this.comandoCorreto = comandoCorreto;
    }

    public Integer getProximaCena() {
        return proximaCena;
    }

    public void setProximaCena(Integer proximaCena) {
        this.proximaCena = proximaCena;
    }

    public Boolean getPodeCarregar() {
        return podeCarregar;
    }

    public void setPodeCarregar(Boolean podeCarregar) {
        this.podeCarregar = podeCarregar;
    }
}
