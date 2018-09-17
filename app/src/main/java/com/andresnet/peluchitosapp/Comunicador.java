package com.andresnet.peluchitosapp;

public interface Comunicador {
    public void SendData(int cid, int cCanti, double cPrecio, String cNombre);
    public void dSendData(String dNombre);
    public void sSendData(String sNombre);
}
