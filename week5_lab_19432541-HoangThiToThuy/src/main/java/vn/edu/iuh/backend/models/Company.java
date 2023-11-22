package vn.edu.iuh.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comp_id")
    private long id;
    @Column(name = "about", length = 2000, nullable = false)
    private String about;
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    @Column(name = "comp_name", length = 255, nullable = false)
    private String comp_name;
    @Column(name = "phone", nullable = false)
    private String  phone;
    @Column(name = "web_url", nullable = false)
    private String web_url;
    @ManyToOne
    @JoinColumn(name = "address")
    private Address address;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company(String about, String email, String comp_name, String phone, String web_url, Address address) {
        this.about = about;
        this.email = email;
        this.comp_name = comp_name;
        this.phone = phone;
        this.web_url = web_url;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", comp_name='" + comp_name + '\'' +
                ", phone='" + phone + '\'' +
                ", web_url='" + web_url + '\'' +
                ", address=" + address +
                '}';
    }
}