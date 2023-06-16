package com.example.drawertry;

public class Notas {
    private int customerid;
    private int notasId;
    private String asunto;
    private String nota;
    private boolean activoSN;

    public Notas() {
    }

    public Notas(int notasId, int customerid, String asunto, String nota, boolean activoSN) {
        this.notasId = notasId;
        this.customerid = customerid;
        this.asunto = asunto;
        this.nota = nota;
        this.activoSN = activoSN;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getNotasId() {
        return notasId;
    }

    public void setNotasId(int notasId) {
        this.notasId = notasId;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public boolean isActivoSN() {
        return activoSN;
    }

    public void setActivoSN(boolean activoSN) {
        this.activoSN = activoSN;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "customerid=" + customerid +
                ", notasId=" + notasId +
                ", asunto='" + asunto + '\'' +
                ", nota='" + nota + '\'' +
                ", activoSN=" + activoSN +
                '}';
    }
}
