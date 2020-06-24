package com.neosofttech.SpringBootRestPOC.Commons;

import java.time.format.DateTimeFormatter;

public interface CommonConstants {

    public static final String SUCCESS_STATUS = "Success";
    public static final String FAIL_STATUS = "Failed";

    public final DateTimeFormatter DTF_MM_yy = DateTimeFormatter.ofPattern("MM-yy");
    public final DateTimeFormatter DTF_MM_yyyy = DateTimeFormatter.ofPattern("MM-yyyy");
    public final DateTimeFormatter DTF_dd_MM_yy = DateTimeFormatter.ofPattern("dd-MM-yy");
    public final DateTimeFormatter DTF_dd_MM_yyyy = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    public final DateTimeFormatter DTF_dd_SLASH_MM_SLASH_yy = DateTimeFormatter.ofPattern("dd/MM/yy");
    public final DateTimeFormatter DTF_dd_SLASH_MM_SLASH_yyyy = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public final DateTimeFormatter DTF_MM_dd_yy = DateTimeFormatter.ofPattern("MM-dd-yy");
    public final DateTimeFormatter DTF_MM_dd_yyyy = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    public final DateTimeFormatter DTF_M_SLASH_d_SLASH_yy =DateTimeFormatter.ofPattern("M/d/yy");
    public final DateTimeFormatter DTF_MM_SLASH_dd_SLASH_yy = DateTimeFormatter.ofPattern("MM/dd/yy");
    public final DateTimeFormatter DTF_MM_SLASH_dd_SLASH_yyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public final DateTimeFormatter DTF_yyyyMMdd = DateTimeFormatter.ofPattern("yyyy MM dd");
    public final DateTimeFormatter DTF_yyyMMddHHmmSSSSS = DateTimeFormatter.ofPattern("yyyyMMddHHmmSS");
    public final DateTimeFormatter DTF_ddMMyyyy_HHmmSS_SSS = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
}
