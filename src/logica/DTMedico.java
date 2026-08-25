package logica;

public class DTMedico extends DTUsuario {

    private int numReg;
    private int mesUL;
    private float porcentajeAd;
    private String web;

    public DTMedico(
            String nickname,
            String nombre,
            String apellido,
            String mail,
            int numReg,
            int mesUL,
            float porcentajeAd,
            String web) {

        super(nickname, nombre, apellido, mail);

        this.numReg = numReg;
        this.mesUL = mesUL;
        this.porcentajeAd = porcentajeAd;
        this.web = web;
    }

    public int getNumReg() {
        return numReg;
    }

    public int getMesUL() {
        return mesUL;
    }

    public float getPorcentajeAd() {
        return porcentajeAd;
    }

    public String getWeb() {
        return web;
    }
}