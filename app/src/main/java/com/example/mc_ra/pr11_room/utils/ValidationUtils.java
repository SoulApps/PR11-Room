package com.example.mc_ra.pr11_room.utils;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.example.mc_ra.pr11_room.databinding.ActivityCompanyDetailBinding;

public class ValidationUtils {

    private ValidationUtils() {
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phoneNumber) {
        return !TextUtils.isEmpty(phoneNumber) && Patterns.PHONE.matcher(phoneNumber).matches();
    }

    public static boolean isValidUrl(String url) {
        return !TextUtils.isEmpty(url) && Patterns.WEB_URL.matcher(url).matches();
    }

    public static boolean isValidAddress(String address) {
        return !TextUtils.isEmpty(address);
    }

    public static boolean checkEmpty(ActivityCompanyDetailBinding mBinding) {
        boolean valid = false;
        if (!TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtCpmpanyName.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtAddress.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtCIF.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtPhone.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtEmail.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtURL.getText().toString())
                && !TextUtils.isEmpty(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtContact.getText().toString())) {
            // If all editext are filled
            if (isValidEmail(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtEmail.getText().toString())
                    && isValidPhone(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtPhone.getText().toString())
                    && isValidUrl(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtURL.getText().toString())) {
                // and have correct data, valid is true
                valid = true;
            }
        }
        return valid;
    }
}
