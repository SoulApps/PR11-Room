package com.example.mc_ra.pr11_room.data.model;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.utils.RecyclerBindingAdapter;

@Entity
public class Company  extends BaseObservable implements RecyclerBindingAdapter.ViewModel, Parcelable {
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

    public Company(String name, String CIF, String address, String phone, String mail, String url, String contactName) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.CIF);
        dest.writeString(this.address);
        dest.writeString(this.phone);
        dest.writeString(this.mail);
        dest.writeString(this.url);
        dest.writeString(this.contactName);
    }

    protected Company(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.CIF = in.readString();
        this.address = in.readString();
        this.phone = in.readString();
        this.mail = in.readString();
        this.url = in.readString();
        this.contactName = in.readString();
    }

    public static final Parcelable.Creator<Company> CREATOR = new Parcelable.Creator<Company>() {
        @Override
        public Company createFromParcel(Parcel source) {
            return new Company(source);
        }

        @Override
        public Company[] newArray(int size) {
            return new Company[size];
        }
    };
}
