package br.com.zup.E_comerce.dto;

public class ClientesDTO {
    private String nomeusuarioDTO;
    private String CPFDTO; //(único e válido).
    private String emailDTO; //(único e válido).

    public ClientesDTO() {
    }

    public ClientesDTO(String CPFDTO, String emailDTO, String nomeusuarioDTO) {
        this.CPFDTO = CPFDTO;
        this.emailDTO = emailDTO;
        this.nomeusuarioDTO = nomeusuarioDTO;
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
