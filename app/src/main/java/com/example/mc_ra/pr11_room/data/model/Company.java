package com.example.mc_ra.pr11_room.data.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;

import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.utils.RecyclerBindingAdapter;

@Entity
public class Company  extends BaseObservable implements RecyclerBindingAdapter.ViewModel {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String CIF;
    private String address;
    private String phone;
    private String mail;
    private String url;
    private String contactName;

    public Company() {
    }

    public Company(long id, String name, String CIF, String address, String phone, String mail, String url, String contactName) {
        this.id = id;
        this.name = name;
        this.CIF = CIF;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.url = url;
        this.contactName = contactName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Ignore
    @Override
    public int getLayoutId() {
        return R.layout.fragment_company_item;
    }
}
