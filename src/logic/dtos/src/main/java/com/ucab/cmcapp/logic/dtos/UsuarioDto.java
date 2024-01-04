package com.ucab.cmcapp.logic.dtos;


import javax.persistence.Column;
import java.util.List;




public class UsuarioDto extends BaseDto
{
    private String _Username;
    private String _Correo;
    private String _Nombre;
    private UserTypeDto _userType;
    private String DocIdentidad;
    private String IMEI;
    private boolean Estatus;
    private String _Password;

    //private List<AlertaDto> alertas;


    public UsuarioDto()
    {
    }

    public UsuarioDto( long id )
    {
        super( id );
    }



    public String get_Username() {
        return _Username;
    }

    public void set_Username(String _Username) {
        this._Username = _Username;
    }

    public String get_Correo() {
        return _Correo;
    }

    public void set_Correo(String _Correo) {
        this._Correo = _Correo;
    }

    public String get_Nombre() {
        return _Nombre;
    }

    public void set_Nombre(String _Nombre) {
        this._Nombre = _Nombre;
    }


    public UserTypeDto getUsuarioTypeDto()
    {
        return _userType;
    }

    public void setUsuarioTypeDto( UserTypeDto userType )
    {
        _userType = userType;
    }

    public String getDocIdentidad() {
        return DocIdentidad;
    }

    public void setDocIdentidad(String docIdentidad) {
        DocIdentidad = docIdentidad;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public boolean isEstatus() {
        return Estatus;
    }

    public void setEstatus(boolean estatus) {
        Estatus = estatus;
    }

    public String get_Password() {
        return _Password;
    }

    public void set_Password(String _Password) {
        this._Password = _Password;
    }

    /*
    public List<AlertaDto> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<AlertaDto> alertas) {
        this.alertas = alertas;
    }

 */
}
