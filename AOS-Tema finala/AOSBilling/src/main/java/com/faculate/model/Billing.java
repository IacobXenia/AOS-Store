package com.faculate.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing")
public class Billing {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long idBilling;

	    @Column(name="destinatar")
	    private String destinatar;
	    @Column(name="address")
	    private String address;
	    @Column(name="product")
	    private String product;


		public Billing() {
	    }

	    public Billing(String destinatar, String address, String product) {
	        this.destinatar = destinatar;
	        this.address = address;
            this.product=product;
	    }

		public long getId() {
			return idBilling;
		}

		public void setId(int id) {
			this.idBilling = id;
		}

		public String getDestinatar() {
			return destinatar;
		}

		public void setDestinatar(String destinatar) {
			this.destinatar = destinatar;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}
	    
		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Billing billing = (Billing) o;
	        return idBilling == billing.idBilling &&
	                Objects.equals(destinatar, billing.destinatar) &&
	                Objects.equals(address, billing.address) &&
	                Objects.equals(product, billing.product);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idBilling, destinatar, address, product);
	    }

	    @Override
	    public String toString() {
	        return "Customer{" +
	                "id=" + idBilling +
	                ", destinatar='" + destinatar + '\'' +
	                ", address='" + address + '\'' +
	                ", product='" + product + '\'' +
	                '}';
	    }
}
