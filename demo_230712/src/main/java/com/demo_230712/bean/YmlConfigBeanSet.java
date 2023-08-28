package com.demo_230712.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取配置文件中的参数, 将其赋值给YmlConfigBean中的静态参数
 *
 * @author zhang_yong
 * @since 2022/01/04
 */
@Component
public class YmlConfigBeanSet {
    @Value("${demo.file-upload.file-path}")
    public void setMedicalInterCstype(String fileUploadPath) {
        YmlConfigBean.FILE_UPLOAD_PATH = fileUploadPath;
    }

    @Value("${aliy-ocr.appcode}")
    public void setAccessKeyId(String appcode) {
        YmlConfigBean.APPCODE = appcode;
    }

    @Value("${aliy-ocr.invoice.host}")
    public void setAccessKeySecret(String host) {
        YmlConfigBean.INVOICE_HOST = host;
    }

    @Value("${aliy-ocr.invoice.path}")
    public void setKmsSwitch(String path) {
        YmlConfigBean.INVOICE_PATH = path;
    }

    @Value("#{'${demo.permission.excludePath}'.split(',')}")
    public void setExcludePath(List<String> path){
        YmlConfigBean.EXCLUDE_PATH = path;

    }

    /*@Value("${chjb.map.baseUrl}")
    public void setBaseUrl(String value) {
        YmlConfigBean.baseUrl = value;
    }

    @Value("${chjb.map.batch}")
    public void setBatch(String value) {
        YmlConfigBean.batch = value;
    }

    @Value("${chjb.map.output}")
    public void setOutput(String value) {
        YmlConfigBean.output = value;
    }

    @Value("${chjb.map.mapKey}")
    public void setMapKey(String value) {
        YmlConfigBean.mapKey = value;
    }

    @Value("${chjb.video.appId}")
    public void setVideoAppidh(String key) {
        YmlConfigBean.VIDEO_APPID = key;
    }

    @Value("${chjb.video.appCertificate}")
    public void setVideoAppcertificate(String key) {
        YmlConfigBean.VIDEO_APPCERTIFICATE = key;
    }

    @Value("${chjb.video.expireTimestamp}")
    public void setVideoExpiretimestamp(int key) {
        YmlConfigBean.VIDEO_EXPIRETIMESTAMP = key;
    }


    @Value("${chjb.ftp.local.save.basepath}")
    public void setFtpLocalSaveBasepath(String key) {
        YmlConfigBean.FTP_LOCAL_SAVE_BASEPATH = key;
    }

    @Value("${chjb.ftp.host}")
    public void setFtpHost(String key) {
        YmlConfigBean.FTP_HOST = key;
    }

    @Value("${chjb.ftp.port}")
    public void setFtpPort(Integer key) {
        YmlConfigBean.FTP_PORT = key;
    }

    @Value("${chjb.ftp.username}")
    public void setFtpUsername(String key) {
        YmlConfigBean.FTP_USERNAME = key;
    }

    @Value("${chjb.ftp.password}")
    public void setFtpPassword(String key) {
        YmlConfigBean.FTP_PASSWORD = key;
    }

    @Value("${chjb.ftp.basepath}")
    public void setFtpBasepath(String key) {
        YmlConfigBean.FTP_BASEPATH = key;
    }

    @Value("${chjb.ftp.localBackup}")
    public void setFtpBasepathLocalbackup(String key) {
        YmlConfigBean.FTP_BASEPATH_LOCALBACKUP = YmlConfigBean.SFTP_BASEPATH + key;
    }

    @Value("${chjb.localBackup.save.basepath}")
    public void setFtpLocalbackupSaveBasepath(String key) {
        YmlConfigBean.LOCALBACKUP_SAVE_BASEPATH = key;
    }


    @Value("${chjb.sftp.local.save.basepath}")
    public void setSftpLocalSaveBasepath(String key) {
        YmlConfigBean.SFTP_LOCAL_SAVE_BASEPATH = key;
    }

    @Value("${chjb.sftp.host}")
    public void setSftpHost(String key) {
        YmlConfigBean.SFTP_HOST = key;
    }

    @Value("${chjb.sftp.port}")
    public void setSftpPort(Integer key) {
        YmlConfigBean.SFTP_PORT = key;
    }

    @Value("${chjb.sftp.username}")
    public void setSftpUsername(String key) {
        YmlConfigBean.SFTP_USERNAME = key;
    }

    @Value("${chjb.sftp.password}")
    public void setSftpPassword(String key) {
        YmlConfigBean.SFTP_PASSWORD = key;
    }

    @Value("${chjb.sftp.basepath}")
    public void setSftpBasepath(String key) {
        YmlConfigBean.SFTP_BASEPATH = key;
    }

    @Value("${chjb.sftp.localBackup}")
    public void setSftpBasepathLocalbackup(String key) {
        YmlConfigBean.SFTP_BASEPATH_LOCALBACKUP = YmlConfigBean.SFTP_BASEPATH + key;
    }

    @Value("${chjb.file-download.template}")
    private void setTemplateBasePath(String key) {
        YmlConfigBean.TEMPLATE_BASE_PATH = key;
    }

    @Value("${chjb.file-download.config}")
    private void setImgBasePath(String key) {
        YmlConfigBean.IMG_BASE_PATH = key;
    }

    @Value("${chjb.file-download.config}")
    private void setFontBasePath(String key) {
        YmlConfigBean.FONT_BASE_PATH = key;
    }

    @Value("#{'${chjb.param.phone}'.split(',')}")
    private void setPhoneParam(List<String> key) {
        YmlConfigBean.PHONE_PARAM = key;
    }

    @Value("${chjb.param.idcard}")
    private void setIdCardParam(String key) {
        YmlConfigBean.ID_CARD_PARAM = key;
    }

    @Value("#{'${chjb.param.accountCode}'.split(',')}")
    private void setAccountCodeParam(List<String> key) {
        YmlConfigBean.ACCOUNT_CODE_PARAM = key;
    }

    @Value("#{'${chjb.param.time}'.split(',')}")
    private void setTimeParam(List<String> key) {
        YmlConfigBean.TIME_PARAM = key;
    }

    @Value("${chjb.switch.hideParam}")
    private void setHideParam(boolean key) {
        YmlConfigBean.HIDE_PARAM = key;
    }

    @Value("${chjb.switch.checkParam}")
    private void setCheckParam(boolean key) {
        YmlConfigBean.CHECK_PARAM = key;
    }

    @Value("#{'${chjb.manage-org}'}")
    private void setManageOrg(String key) {
        YmlConfigBean.MANAGE_ORG = key;
    }

    @Value("#{'${chjb.support-region}'}")
    private void setSupportStreet(String key) {
        YmlConfigBean.SUPPORT_REGION = key;
    }

    @Value("#{'${chjb.autograph-user}'.split(',')}")
    private void setAutographUser(List<String> key) {
        YmlConfigBean.AUTOGRAPH_USER = key;
    }

    @Value("#{'${chjb.lockAccount.switch}'}")
    private void setLockAccountSwitch(String key) {
        YmlConfigBean.LOCK_ACCOUNT_SWITCH = key;
    }

    @Value("#{'${chjb.password-level}'}")
    private void setPasswordLevel(Integer key) {
        YmlConfigBean.PASSWORD_LEVEL = key;
    }

    @Value("#{'${chjb.desensitization-switch}'}")
    private void setDesensitizationSwitch(Integer key) {
        YmlConfigBean.DESENSITIZATION_SWITCH = key;
    }

    @Value("#{'${chjb.verify-code-data-source}'}")
    private void setVerifyCodeDataSource(String key) {
        YmlConfigBean.VERIFY_CODE_DATA_SOURCE = key;
    }

    @Value("#{'${chjb.encrypt.on-off}'}")
    private void setEncryptOnOff(Integer key) {
        YmlConfigBean.ENCRYPT_ON_OFF = key;
    }

    @Value("#{'${chjb.white-roster}'}")
    private void setWhiteRoster(Integer key) {
        YmlConfigBean.WHITE_ROSTER = key;
    }

    @Value("#{'${chjb.license-switch}'}")
    private void setLicenseSwitch(Integer key) {
        YmlConfigBean.LICENSE_SWITCH = key;
    }

    @Value("#{'${chjb.license-duration}'}")
    private void setLicenseDuration(Integer key) {
        YmlConfigBean.LICENSE_DURATION = key;
    }

    @Value("#{'${chjb.encrypt.ignorePath}'.split(',')}")
    private void setEncryptIgnorePath(List<String> key) {
        YmlConfigBean.ENCRYPT_IGNORE_PATH = key;
    }

    @Value("#{'${chjb.file-download.download-path}'}")
    private void setDownLoadPath(String key) {
        YmlConfigBean.DOWN_LOAD_PATH = key;
    }

    @Value("#{'${chjb.file-download.cz-download-path}'}")
    private void setCzDownloadPath(String key) {
        YmlConfigBean.CZ_DOWNLOAD_PATH = key;
    }

    @Value("#{'${chjb.file-download.return-path}'}")
    private void setReturnPath(String key) {
        YmlConfigBean.RETURN_PATH = key;
    }

    @Value("#{'${chjb.file-download.public-export-path}'}")
    private void setPublicExportPath(String key) {
        YmlConfigBean.PUBLIC_EXPORT_PATH = key;
    }

    @Value("#{'${chjb.inter.Medical.url}'}")
    private void setInterMedicalUrl(String interMedicalUrl) {
        YmlConfigBean.INTER_MEDICAL_URL = interMedicalUrl;
    }

    @Value("#{'${chjb.inter.Medical.pwd}'}")
    public void setInterMedicalPwd(String interMedicalPwd) {
        YmlConfigBean.INTER_MEDICAL_PWD = interMedicalPwd;
    }

    @Value("#{'${chjb.inter.Medical.address.login}'}")
    public void setInterMedicalAddressLogin(String interMedicalAddressLogin) {
        YmlConfigBean.INTER_MEDICAL_ADDRESS_LOGIN = interMedicalAddressLogin;
    }

    @Value("#{'${chjb.inter.Medical.address.gauge}'}")
    public void setInterMedicalAddressGauge(String interMedicalAddressGauge) {
        YmlConfigBean.INTER_MEDICAL_ADDRESS_GAUGE = interMedicalAddressGauge;
    }

    @Value("#{'${chjb.file-upload.file-download-path}'}")
    public void setImageFilePath(String fileDownloadPath) {
        YmlConfigBean.FILE_DOWNLOAD_PATH = fileDownloadPath;
    }

    @Value("#{'${chjb.file-download.public-file-path}'}")
    public void setGongShiFile(String key) {
        YmlConfigBean.PUBLIC_FILE_PATH = key;
    }

    @Value("#{'${chjb.file-download.finish-public-file-path}'}")
    public void setFinishPublicFilePath(String key) {
        YmlConfigBean.FINISH_PUBLIC_FILE_PATH = key;
    }

    @Value("#{'${chjb.file-download.public-attachment-path}'}")
    public void setPublicAttachmentPath(String key) {
        YmlConfigBean.PUBLIC_ATTACHMENT_PATH = key;
    }

    @Value("#{'${chjb.file-download.finish-public-attachment-path}'}")
    public void setFinishPublicAttachmentPath(String key) {
        YmlConfigBean.FINISH_PUBLIC_ATTACHMENT_PATH = key;
    }

    @Value("#{'${chjb.file-upload.file-dir}'.split(',')}")
    public void setFileUploadDir(List<String> key) {
        YmlConfigBean.FILE_UPLOAD_DIR = key;
    }

    @Value("#{'${chjb.file-upload.file-size}'}")
    public void setFileSize(String fileSize) {
        YmlConfigBean.FILE_SIZE_MAX = fileSize;
    }

    private String fileSizeString;

    @Value("#{'${chjb.autograph.evaluate-org}'}")
    public void setAutographEvaluateOrg(String autographEvaluateOrg) {
        YmlConfigBean.AUTOGRAPH_EVALUATE_ORG = autographEvaluateOrg;
    }

    @Value("#{'${chjb.autograph.expert}'}")
    public void setAutographExpert(String autographExpert) {
        YmlConfigBean.AUTOGRAPH_EXPERT = autographExpert;
    }

    @Value("#{'${chjb.filter.corsInfo}'}")
    public void setFilterCorsInfo(String key) {
        YmlConfigBean.FILTER_CORSINFO = key;
    }

    @Value("#{'${chjb.file-upload.file-path}'}")
    public void setFilePath(String filePath) {
        YmlConfigBean.FILE_PATH = filePath;
    }

    //亲情护理人员机构和角色
    @Value("#{'${chjb.CostSettlementDate.switch}'}")
    public void setCostSettlementDateSwitch(String costSettlementDateSwitch){
        YmlConfigBean.SWITCH = costSettlementDateSwitch;
    }

    //亲情护理人员机构和角色
    @Value("#{'${chjb.homecare.org-code}'}")
    public void sethomeCareOrgCode(String homeCareOrgCode){
        YmlConfigBean.HOME_CARE_ORG_CODE = homeCareOrgCode;
    }

    @Value("#{'${chjb.homecare.role-code}'}")
    public void sethomeCareRoleCode(String homeCareroleCode){
        YmlConfigBean.HOME_CARE_ROLE_CODE = homeCareroleCode;
    }



    //判断是否是节假日的请求url
    @Value("#{'${chjb.date-holiday-url}'}")
    private void setHolidayUrl(String holidayUrl) {
        YmlConfigBean.HOLIDAY_URL = holidayUrl;
    }

    @Value("#{'${chjb.sftp.sftpReceivePath}'}")
    public void setSftpReceivePath(String sftpReceivePath) {
        YmlConfigBean.SFTP_RECEIVE_PATH = sftpReceivePath;
    }

    @Value("#{'${chjb.sftp.sftpGeneratePath}'}")
    public void setSftpGeneratePath(String sftpGeneratePath) {
        YmlConfigBean.SFTP_GENERATE_PATH = sftpGeneratePath;
    }

    @Value("${chjb.medicalInter.type}")
    public void setMedicalInterType(String medicalInterType) {
        YmlConfigBean.MEDICAL_INTER_TYPE = medicalInterType;
    }

    @Value("${chjb.medicalInter.proUrl}")
    public void setMedicalProUrl(String medicalProUrl) {
        YmlConfigBean.MEDICAL_PRO_URL = medicalProUrl;
    }

    @Value("${chjb.medicalInter.tesUrl}")
    public void setMedicalTesUrl(String medicalTesUrl) {
        YmlConfigBean.MEDICAL_TES_URL = medicalTesUrl;
    }

    @Value("#{'${chjb.obs.obs-switch}'}")
    public void setObsSwitch(String obsSwitch) {
        YmlConfigBean.OBS_SWITCH = obsSwitch;
    }

    @Value("#{'${chjb.obs.obs-ngUrl}'}")
    public void setObsNgUrl(String obsNgUrl) {
        YmlConfigBean.OBS_NG_URL = obsNgUrl;
    }


    @Value("#{'${chjb.obs.obs-endpoint}'}")
    public void setObsEndpoint(String obsEndpoint) {
        YmlConfigBean.OBS_ENDPOINT = obsEndpoint;
    }

    @Value("#{'${chjb.obs.obs-ak}'}")
    public void setObsAk(String obsAk) {
        YmlConfigBean.OBS_AK = obsAk;
    }

    @Value("#{'${chjb.obs.obs-sk}'}")
    public void setObsSk(String obsSk) {
        YmlConfigBean.OBS_SK = obsSk;
    }

    @Value("#{'${chjb.obs.obs-bucket}'}")
    public void setObsBucket(String obsBucket) {
        YmlConfigBean.OBS_BUCKET = obsBucket;
    }

    @Value("#{'${chjb.obs.obs-image}'}")
    public void setObsImage(String obsImage) {
        YmlConfigBean.OBS_IMAGE = obsImage;
    }

    @Value("#{'${chjb.obs.obs-attach}'}")
    public void setObsAttach(String obsAttach) {
        YmlConfigBean.OBS_ATTACH = obsAttach;
    }

    @Value("#{'${chjb.obs.obs-video}'}")
    public void setObsVideo(String obsVideo) {
        YmlConfigBean.OBS_VIDEO = obsVideo;
    }

    @Value("#{'${chjb.obs.obs-audio}'}")
    public void setObsAudio(String obsAudio) {
        YmlConfigBean.OBS_AUDIO = obsAudio;
    }

    @Value("#{'${chjb.obs.obs-template}'}")
    public void setObsTemplate(String obsTemplate) {
        YmlConfigBean.OBS_TEMPLATE = obsTemplate;
    }

    @Value("#{'${chjb.medicalShiInter.accessKeyId}'}")
    public void setMedicalAccessKeyId(String medicalAccessKeyId) {
        YmlConfigBean.MEDICAL_ACCESS_KEY_ID = medicalAccessKeyId;
    }

    @Value("#{'${chjb.medicalShiInter.accessKeySecret}'}")
    public void setMedicalAccessKeySecret(String medicalAccessKeySecret) {
        YmlConfigBean.MEDICAL_ACCESS_KEY_SECRET = medicalAccessKeySecret;
    }

    @Value("#{'${chjb.medicalShiInter.medicalInsuranceUrl}'}")
    public void setMedicalInsuranceUrl(String medicalInsuranceUrl) {
        YmlConfigBean.MEDICAL_INSURANCE_URL = medicalInsuranceUrl;
    }

    @Value("#{'${chjb.CostOrgTaskMonth}'}")
    public void setCostOrgTaskMonth(String costOrgTaskMonth){
        YmlConfigBean.COST_ORG_TASK_MONTH = costOrgTaskMonth;
    }

    @Value("#{'${chjb.encryption-type}'}")
    public void setEncryptionType(String key){
        YmlConfigBean.ENCRYPTION_TYPE = key;
    }

    @Value("${chjb.video.appliteDir}")
    public void setVideoAppliteDir(String key) {
        YmlConfigBean.VIDEO_APPLITEDIR = key;
    }
    @Value("${chjb.video.recordFileRootDir}")
    public void setVideoRecordFileRootDir(String key) {
        YmlConfigBean.VIDEO_RECORDFILEROOTDIR = key;
    }*/
}
