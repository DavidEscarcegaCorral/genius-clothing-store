package dominio;

public class DireccionEntidad {
    private String id;
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String referencias;

    public DireccionEntidad() {
    }

    public DireccionEntidad(String id,
                            String calle,
                            String numeroExterior,
                            String numeroInterior,
                            String colonia,
                            String ciudad,
                            String estado,
                            String codigoPostal,
                            String referencias) {
        this.id = id;
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.referencias = referencias;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    /**
     * Retorna la dirección completa formateada
     */
    public String getDireccionCompleta() {
        StringBuilder sb = new StringBuilder();
        sb.append(calle != null ? calle : "").append(" ");
        sb.append(numeroExterior != null ? numeroExterior : "");
        if (numeroInterior != null && !numeroInterior.trim().isEmpty()) {
            sb.append(", Int. ").append(numeroInterior);
        }
        sb.append(", Col. ").append(colonia != null ? colonia : "");
        sb.append(", ").append(ciudad != null ? ciudad : "");
        sb.append(", ").append(estado != null ? estado : "");
        sb.append(", C.P. ").append(codigoPostal != null ? codigoPostal : "");

        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "DireccionEntidad{" +
                "id='" + id + '\'' +
                ", calle='" + calle + '\'' +
                ", numeroExterior='" + numeroExterior + '\'' +
                ", numeroInterior='" + numeroInterior + '\'' +
                ", colonia='" + colonia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", referencias='" + referencias + '\'' +
                '}';
    }
}
