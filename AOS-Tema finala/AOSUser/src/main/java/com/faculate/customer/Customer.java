package com.faculate.customer;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCustomer;
    @Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
    
	public Customer() {}

    public Customer(Integer id,String name,String address){
		 super();
		 this.idCustomer=id;
		 this.name=name;
		 this.address=address;
	    }
	
	public long getId() {
		return idCustomer;
	}
	public void setId(Integer id) {
		this.idCustomer = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return idCustomer == customer.idCustomer &&
                Objects.equals(name, customer.name) &&
                Objects.equals(address, customer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, name, address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + idCustomer +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
