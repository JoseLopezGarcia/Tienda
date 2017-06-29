/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jose
 */
public class Venta {
    private int IdVenta;
    private int IdSucursal;
    private int IdPrecio;
    private Date Fecha;
    private double IVA;
    private double TotalGravado;
    private double Total;
    private String Cliente;
    private String Direccion;
    private String Giro;
    private String NIT;
    private String NRC;
    private String NomDocumento;
    private char IdTipoVenta;
    private ArrayList<Object> Articulos = new ArrayList<>();
    
    public void AgregarItem(DetalleVenta item){
        
        Articulos.add(this.IdVenta);
        Articulos.add(item.getCodBarra());
        Articulos.add(item.getCantidad());
        Articulos.add(item.getPrecioUnitario());
        System.out.println("Agregar nuevo item");
    }
    public void CalcularTotal(){
        this.Total=this.TotalGravado+this.IVA;
        
    }
    public double CalcularIVA(){
        double conImpuesto =0;
        conImpuesto =this.TotalGravado*1.13;
        this.IVA=conImpuesto-TotalGravado;
        
        return conImpuesto;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getIdSucursal() {
        return IdSucursal;
    }

    public void setIdSucursal(int IsSucursal) {
        this.IdSucursal = IsSucursal;
    }

    public int getIdPrecio() {
        return IdPrecio;
    }

    public void setIdPrecio(int IdPrecio) {
        this.IdPrecio = IdPrecio;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotalGravado() {
        return TotalGravado;
    }

    public void setTotalGravado(double TotalGravado) {
        this.TotalGravado = TotalGravado;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getGiro() {
        return Giro;
    }

    public void setGiro(String Giro) {
        this.Giro = Giro;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getNRC() {
        return NRC;
    }

    public void setNRC(String NRC) {
        this.NRC = NRC;
    }

    public String getNomDocumento() {
        return NomDocumento;
    }

    public void setNomDocumento(String NomDocumento) {
        this.NomDocumento = NomDocumento;
    }

    public char getIdTipoVenta() {
        return IdTipoVenta;
    }

    public void setIdTipoVenta(char IdTipoVenta) {
        this.IdTipoVenta = IdTipoVenta;
    }

    public ArrayList<Object> getArticulos() {
        return Articulos;
    }

   
    
    
}
