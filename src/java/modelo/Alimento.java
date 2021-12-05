/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Misael
 */
@Entity
@Table(name = "ALIMENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimento.findAll", query = "SELECT a FROM Alimento a"),
    @NamedQuery(name = "Alimento.findByIdalimento", query = "SELECT a FROM Alimento a WHERE a.idalimento = :idalimento"),
    @NamedQuery(name = "Alimento.findByDescripcion", query = "SELECT a FROM Alimento a WHERE a.descripcion = :descripcion"),
    @NamedQuery(name = "Alimento.findByCantidad", query = "SELECT a FROM Alimento a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Alimento.findByPrecio", query = "SELECT a FROM Alimento a WHERE a.precio = :precio"),
    @NamedQuery(name = "Alimento.findByFechaCaducidad", query = "SELECT a FROM Alimento a WHERE a.fechaCaducidad = :fechaCaducidad")})
public class Alimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALIMENTO")
    private Integer idalimento;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;
    @Column(name = "FECHA_CADUCIDAD")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;

    public Alimento() {
    }

    public Alimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimento)) {
            return false;
        }
        Alimento other = (Alimento) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alimento[ idalimento=" + idalimento + " ]";
    }
    
}
