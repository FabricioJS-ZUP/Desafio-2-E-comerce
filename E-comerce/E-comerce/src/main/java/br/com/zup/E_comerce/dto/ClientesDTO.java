package br.com.zup.E_comerce.dto;

public class ClientesDTO {
    private long id;
    private String nomeusuarioDTO;
    private String CPFDTO; //(único e válido).
    private String emailDTO; //(único e válido).

    public ClientesDTO() {
    }

    public ClientesDTO(String CPFDTO, String emailDTO, long id, String nomeusuarioDTO) {
        this.CPFDTO = CPFDTO;
        this.emailDTO = emailDTO;
        this.id = id;
        this.nomeusuarioDTO = nomeusuarioDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCPFDTO() {
        return CPFDTO;
    }

    public void setCPFDTO(String CPFDTO) {
        this.CPFDTO = CPFDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public String getNomeusuarioDTO() {
        return nomeusuarioDTO;
    }

    public void setNomeusuarioDTO(String nomeusuarioDTO) {
        this.nomeusuarioDTO = nomeusuarioDTO;
    }
}
