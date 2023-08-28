package com.demo_230712.bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 配置文件参数读取
 * Created by chang_kaidi on 2020/7/23 0023.
 */
@Component
public class YmlConfigBean {
    //存放文件模板的地址
    public static volatile String FILE_UPLOAD_PATH;
    //阿里云APPCODE
    public static volatile String APPCODE;
    //阿里云发票识别host
    public static volatile String INVOICE_HOST;
    //阿里云发票识别path
    public static volatile String INVOICE_PATH;
    //不走拦截器的请求
    public static volatile List<String> EXCLUDE_PATH;
    /*//SensitiveInfoUtil_敏感信息处理工具类_身份证号参数
    public static volatile String ID_CARD_PARAM;
    //SensitiveInfoUtil_敏感信息处理工具类_银行卡号参数
    public static volatile List<String> ACCOUNT_CODE_PARAM;
    //SensitiveInfoUtil_敏感信息处理工具类_时间日期参数
    public static volatile List<String> TIME_PARAM;
    //SensitiveInfoUtil_敏感信息处理工具类_是否隐藏参数
    public static volatile boolean HIDE_PARAM;
    //SensitiveInfoUtil_敏感信息处理工具类_是否校验参数
    public static volatile boolean CHECK_PARAM;
    //机构名称
    public static volatile String MANAGE_ORG;
    //支持的统筹区
    public static volatile String SUPPORT_REGION;
    //CalculationExpertAutograph签名顺序
    public static volatile List<String> AUTOGRAPH_USER;
    //账号锁定开关
    public volatile static String LOCK_ACCOUNT_SWITCH;
    //密码等级
    public static volatile Integer PASSWORD_LEVEL;
    //DesensitizationUtil_脱敏开关 0：关 1：开
    public static volatile Integer DESENSITIZATION_SWITCH;
    //验证码数据来源
    public static volatile String VERIFY_CODE_DATA_SOURCE;
    //RSA 加解密开关 0 关 1开
    public static volatile Integer ENCRYPT_ON_OFF;
    //白名单开关 0 关 1 开
    public static volatile Integer WHITE_ROSTER;

    //第三方接口授权开关
    public static volatile Integer LICENSE_SWITCH;
    //第三方接口授权时长
    public static volatile Integer LICENSE_DURATION;

    // 加密忽略集合
    public static volatile List<String> ENCRYPT_IGNORE_PATH;
    public static volatile String DOWN_LOAD_PATH;
    public static volatile String RETURN_PATH;
    public static volatile String PUBLIC_EXPORT_PATH;

    //常州文件下载目录
    public static volatile String CZ_DOWNLOAD_PATH;

    //ftp 的ip
    public static volatile String FTP_HOST;
    //ftp 的端口
    public static volatile Integer FTP_PORT;
    //ftp 的用户名
    public static volatile String FTP_USERNAME;
    //ftp 的密码
    public static volatile String FTP_PASSWORD;
    //ftp 的获取文件路径
    public static volatile String FTP_BASEPATH;
    //ftp 的上传文件备份路径（文件重复）
    public static volatile String FTP_BASEPATH_LOCALBACKUP;
    //ftp 本地保存路径
    public static volatile String FTP_LOCAL_SAVE_BASEPATH;
    // 本地备份保存路径
    public static volatile String LOCALBACKUP_SAVE_BASEPATH;

    //短信keyId
    public static volatile String accessKeyId;
    //短信KeySecret
    public static volatile String accessKeySecret;
    //短信开关
    public static volatile String smsSwitch;

    //经纬度转地址baseUrl
    public static volatile String baseUrl;
    //batch
    public static volatile String batch;
    //output
    public static volatile String output;
    //mapKey
    public static volatile String mapKey;

    //sftp 的ip
    public static volatile String SFTP_HOST;
    //sftp 的端口
    public static volatile Integer SFTP_PORT;
    //sftp 的用户名
    public static volatile String SFTP_USERNAME;
    //sftp 的密码
    public static volatile String SFTP_PASSWORD;


    //从本地服务器上传到sftp   sftp服务器上接收的路径
    public static volatile String SFTP_RECEIVE_PATH;
    //从sftp上获取文件传到本地服务器    sftp上评定等级生成好的Excel的文件目录
    public static volatile String SFTP_GENERATE_PATH;

    //sftp 的获取文件路径
    public static volatile String SFTP_BASEPATH;
    //sftp 的上传文件备份路径（文件重复）
    public static volatile String SFTP_BASEPATH_LOCALBACKUP;
    //sftp 本地保存路径
    public static volatile String SFTP_LOCAL_SAVE_BASEPATH;



    //医保接口url
    public static volatile String INTER_MEDICAL_URL;
    //医保密码
    public static volatile String INTER_MEDICAL_PWD;
    //医保登录
    public static volatile String INTER_MEDICAL_ADDRESS_LOGIN;
    //医保量表
    public static volatile String INTER_MEDICAL_ADDRESS_GAUGE;
    //机构签名
    public static volatile String AUTOGRAPH_EVALUATE_ORG;
    //专家签名地址
    public static volatile String AUTOGRAPH_EXPERT;
    //过滤器修改
    public static volatile String FILTER_CORSINFO;
    //亲情护理人员
    public static volatile String HOME_CARE_ORG_CODE;
    public static volatile String HOME_CARE_ROLE_CODE;

    public static volatile String SWITCH;

    //文件下载路径
    public static volatile String FILE_DOWNLOAD_PATH;
    //文件路径
    public static volatile String FILE_PATH;
    //文件大小
    public static volatile String FILE_SIZE_MAX;
    //文件类别
    public static volatile List<String> FILE_UPLOAD_DIR;
    //公示文件存放目录
    public static volatile String PUBLIC_FILE_PATH;
    //完成公示文件存放目录
    public static volatile String FINISH_PUBLIC_FILE_PATH;
    //发布公示附件存放目录
    public static volatile String PUBLIC_ATTACHMENT_PATH;
    //完成公示附件存放目录
    public static volatile String FINISH_PUBLIC_ATTACHMENT_PATH;



    //视频一对一通话获取RTMToken
    //Agora 控制台 项目管理 App ID
    public static volatile String VIDEO_APPID;
    //App 证书
    public static volatile String VIDEO_APPCERTIFICATE;

    public static volatile int VIDEO_EXPIRETIMESTAMP;

    //判断是否是节假日的请求url
    public static volatile String HOLIDAY_URL;

    //接口对接类型  0-测试 1-生产 2-公司
    public static volatile String MEDICAL_INTER_TYPE;
    //0-医保测试数据 1-生产测试数据
    public static volatile String MEDICAL_INTER_CSTYPE;
    //医保生产地址
    public static volatile String MEDICAL_PRO_URL;
    //医保测试地址
    public static volatile String MEDICAL_TES_URL;

    *//**
     * obs endPoint
     *//*
    public static volatile String OBS_NG_URL;


    *//**
     * obs开关
     *//*
    public static volatile String OBS_SWITCH;

    *//**
     * obs endPoint
     *//*
    public static volatile String OBS_ENDPOINT;

    *//**
     * obs 申请的 appkey
     *//*
    public static volatile String OBS_AK;

    *//**
     * obs 申请的 对应appkey的secret
     *//*
    public static volatile String OBS_SK;

    *//**
     * obs bucket
     *//*
    public static volatile String OBS_BUCKET;

    *//**
     * obs image
     *//*
    public static volatile String OBS_IMAGE;

    *//**
     * obs attach
     *//*
    public static volatile String OBS_ATTACH;

    *//**
     * obs video
     *//*
    public static volatile String OBS_VIDEO;

    *//**
     * obs audio
     *//*
    public static volatile String OBS_AUDIO;

    *//**
     * obs template
     *//*
    public static volatile String OBS_TEMPLATE;


    //医保政务大数据平台相关信息
    //秘钥id
    public static volatile String MEDICAL_ACCESS_KEY_ID;

    //秘钥key
    public static volatile String MEDICAL_ACCESS_KEY_SECRET;

    //平台地址
    public static volatile String MEDICAL_INSURANCE_URL;

    //机构定时任务指定月份:now(当月)，all(全部),2020-05(指定月份)
    public static volatile String COST_ORG_TASK_MONTH;

    //加密方式是否调整 1：是，0：否
    public static volatile String ENCRYPTION_TYPE;

    public volatile static String VIDEO_APPLITEDIR;//AgoraCoreService 存放的目录
    public volatile static String VIDEO_RECORDFILEROOTDIR;//设置录制文件存放的根目录

//    @Value("${chjb.medicalInter.csType}")
//    public void setMedicalInterCstype(String medicalInterCstype) {
//        MEDICAL_INTER_CSTYPE = medicalInterCstype;
//    }
//
//    @Value("${chjb.aliSms.keyId}")
//    public void setAccessKeyId(String keyId) {
//        accessKeyId = keyId;
//    }
//
//    @Value("${chjb.aliSms.keySecret}")
//    public void setAccessKeySecret(String keySecret) {
//        accessKeySecret = keySecret;
//    }
//
//    @Value("${chjb.aliSms.smsSwitch}")
//    public void setKmsSwitch(String value) {
//        smsSwitch = value;
//    }
//
//    @Value("${chjb.map.baseUrl}")
//    public void setBaseUrl(String value) {
//        baseUrl = value;
//    }
//
//    @Value("${chjb.map.batch}")
//    public void setBatch(String value) {
//        batch = value;
//    }
//
//    @Value("${chjb.map.output}")
//    public void setOutput(String value) {
//        output = value;
//    }
//
//    @Value("${chjb.map.mapKey}")
//    public void setMapKey(String value) {
//        mapKey = value;
//    }
//
//    @Value("${chjb.video.appId}")
//    public void setVideoAppidh(String key) {
//        VIDEO_APPID = key;
//    }
//
//    @Value("${chjb.video.appCertificate}")
//    public void setVideoAppcertificate(String key) {
//        VIDEO_APPCERTIFICATE = key;
//    }
//
//    @Value("${chjb.video.expireTimestamp}")
//    public void setVideoExpiretimestamp(int key) {
//        VIDEO_EXPIRETIMESTAMP = key;
//    }
//
//
//    @Value("${chjb.ftp.local.save.basepath}")
//    public void setFtpLocalSaveBasepath(String key) {
//        FTP_LOCAL_SAVE_BASEPATH = key;
//    }
//
//    @Value("${chjb.ftp.host}")
//    public void setFtpHost(String key) {
//        FTP_HOST = key;
//    }
//
//    @Value("${chjb.ftp.port}")
//    public void setFtpPort(Integer key) {
//        FTP_PORT = key;
//    }
//
//    @Value("${chjb.ftp.username}")
//    public void setFtpUsername(String key) {
//        FTP_USERNAME = key;
//    }
//
//    @Value("${chjb.ftp.password}")
//    public void setFtpPassword(String key) {
//        FTP_PASSWORD = key;
//    }
//
//    @Value("${chjb.ftp.basepath}")
//    public void setFtpBasepath(String key) {
//        FTP_BASEPATH = key;
//    }
//
//    @Value("${chjb.ftp.localBackup}")
//    public void setFtpBasepathLocalbackup(String key) {
//        FTP_BASEPATH_LOCALBACKUP = SFTP_BASEPATH + key;
//    }
//
//    @Value("${chjb.localBackup.save.basepath}")
//    public void setFtpLocalbackupSaveBasepath(String key) {
//        LOCALBACKUP_SAVE_BASEPATH = key;
//    }
//
//
//    @Value("${chjb.sftp.local.save.basepath}")
//    public void setSftpLocalSaveBasepath(String key) {
//        SFTP_LOCAL_SAVE_BASEPATH = key;
//    }
//
//    @Value("${chjb.sftp.host}")
//    public void setSftpHost(String key) {
//        SFTP_HOST = key;
//    }
//
//    @Value("${chjb.sftp.port}")
//    public void setSftpPort(Integer key) {
//        SFTP_PORT = key;
//    }
//
//    @Value("${chjb.sftp.username}")
//    public void setSftpUsername(String key) {
//        SFTP_USERNAME = key;
//    }
//
//    @Value("${chjb.sftp.password}")
//    public void setSftpPassword(String key) {
//        SFTP_PASSWORD = key;
//    }
//
//    @Value("${chjb.sftp.basepath}")
//    public void setSftpBasepath(String key) {
//        SFTP_BASEPATH = key;
//    }
//
//    @Value("${chjb.sftp.localBackup}")
//    public void setSftpBasepathLocalbackup(String key) {
//        SFTP_BASEPATH_LOCALBACKUP = SFTP_BASEPATH + key;
//    }
//
//    @Value("${chjb.file-download.template}")
//    private void setTemplateBasePath(String key) {
//        TEMPLATE_BASE_PATH = key;
//    }
//
//    @Value("${chjb.file-download.config}")
//    private void setImgBasePath(String key) {
//        IMG_BASE_PATH = key;
//    }
//
//    @Value("${chjb.file-download.config}")
//    private void setFontBasePath(String key) {
//        FONT_BASE_PATH = key;
//    }
//
//    @Value("#{'${chjb.param.phone}'.split(',')}")
//    private void setPhoneParam(List<String> key) {
//        PHONE_PARAM = key;
//    }
//
//    @Value("${chjb.param.idcard}")
//    private void setIdCardParam(String key) {
//        ID_CARD_PARAM = key;
//    }
//
//    @Value("#{'${chjb.param.accountCode}'.split(',')}")
//    private void setAccountCodeParam(List<String> key) {
//        ACCOUNT_CODE_PARAM = key;
//    }
//
//    @Value("#{'${chjb.param.time}'.split(',')}")
//    private void setTimeParam(List<String> key) {
//        TIME_PARAM = key;
//    }
//
//    @Value("${chjb.switch.hideParam}")
//    private void setHideParam(boolean key) {
//        HIDE_PARAM = key;
//    }
//
//    @Value("${chjb.switch.checkParam}")
//    private void setCheckParam(boolean key) {
//        CHECK_PARAM = key;
//    }
//
//    @Value("#{'${chjb.manage-org}'}")
//    private void setManageOrg(String key) {
//        MANAGE_ORG = key;
//    }
//
//    @Value("#{'${chjb.support-region}'}")
//    private void setSupportStreet(String key) {
//        SUPPORT_REGION = key;
//    }
//
//    @Value("#{'${chjb.autograph-user}'.split(',')}")
//    private void setAutographUser(List<String> key) {
//        AUTOGRAPH_USER = key;
//    }
//
//    @Value("#{'${chjb.password-level}'}")
//    private void setPasswordLevel(Integer key) {
//        PASSWORD_LEVEL = key;
//    }
//
//    @Value("#{'${chjb.desensitization-switch}'}")
//    private void setDesensitizationSwitch(Integer key) {
//        DESENSITIZATION_SWITCH = key;
//    }
//
//    @Value("#{'${chjb.verify-code-data-source}'}")
//    private void setVerifyCodeDataSource(String key) {
//        VERIFY_CODE_DATA_SOURCE = key;
//    }
//
//    @Value("#{'${chjb.encrypt.on-off}'}")
//    private void setEncryptOnOff(Integer key) {
//        ENCRYPT_ON_OFF = key;
//    }
//
//    @Value("#{'${chjb.white-roster}'}")
//    private void setWhiteRoster(Integer key) {
//        WHITE_ROSTER = key;
//    }
//
//    @Value("#{'${chjb.encrypt.ignorePath}'.split(',')}")
//    private void setEncryptIgnorePath(List<String> key) {
//        ENCRYPT_IGNORE_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.download-path}'}")
//    private void setDownLoadPath(String key) {
//        DOWN_LOAD_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.cz-download-path}'}")
//    private void setCzDownloadPath(String key) {
//        CZ_DOWNLOAD_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.return-path}'}")
//    private void setReturnPath(String key) {
//        RETURN_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.public-export-path}'}")
//    private void setPublicExportPath(String key) {
//        PUBLIC_EXPORT_PATH = key;
//    }
//
//    @Value("#{'${chjb.inter.Medical.url}'}")
//    private void setInterMedicalUrl(String interMedicalUrl) {
//        INTER_MEDICAL_URL = interMedicalUrl;
//    }
//    @Value("#{'${chjb.inter.Medical.pwd}'}")
//    public void setInterMedicalPwd(String interMedicalPwd) {
//        INTER_MEDICAL_PWD = interMedicalPwd;
//    }
//
//    @Value("#{'${chjb.inter.Medical.address.login}'}")
//    public void setInterMedicalAddressLogin(String interMedicalAddressLogin) {
//        INTER_MEDICAL_ADDRESS_LOGIN = interMedicalAddressLogin;
//    }
//    @Value("#{'${chjb.inter.Medical.address.gauge}'}")
//    public void setInterMedicalAddressGauge(String interMedicalAddressGauge) {
//        INTER_MEDICAL_ADDRESS_GAUGE = interMedicalAddressGauge;
//    }
//    @Value("#{'${chjb.file-upload.file-download-path}'}")
//    public void setImageFilePath(String fileDownloadPath){
//        FILE_DOWNLOAD_PATH = fileDownloadPath;
//    }
//
//    @Value("#{'${chjb.file-download.public-file-path}'}")
//    public void setGongShiFile(String key){
//        PUBLIC_FILE_PATH = key;
//    }
//    @Value("#{'${chjb.file-download.finish-public-file-path}'}")
//    public void setFinishPublicFilePath(String key){
//        FINISH_PUBLIC_FILE_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.public-attachment-path}'}")
//    public void setPublicAttachmentPath(String key){
//        PUBLIC_ATTACHMENT_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-download.finish-public-attachment-path}'}")
//    public void setFinishPublicAttachmentPath(String key){
//        FINISH_PUBLIC_ATTACHMENT_PATH = key;
//    }
//
//    @Value("#{'${chjb.file-upload.file-dir}'.split(',')}")
//    public void setFileUploadDir(List<String> key){
//        FILE_UPLOAD_DIR = key;
//    }
//
//    @Value("#{'${chjb.file-upload.file-size}'}")
//    public void setFileSize(String fileSize){
//        FILE_SIZE_MAX = fileSize;
//    }
//    private String fileSizeString;
//
//    @Value("#{'${chjb.autograph.evaluate-org}'}")
//    public void setAutographEvaluateOrg(String autographEvaluateOrg){
//        AUTOGRAPH_EVALUATE_ORG = autographEvaluateOrg;
//    }
//
//    @Value("#{'${chjb.autograph.expert}'}")
//    public void setAutographExpert(String autographExpert){
//        AUTOGRAPH_EXPERT = autographExpert;
//    }
//
//    @Value("#{'${chjb.file-upload.file-path}'}")
//    public void setFilePath(String filePath){
//        FILE_PATH = filePath;
//    }
//
//    //判断是否是节假日的请求url
//    @Value("#{'${chjb.date-holiday-url}'}")
//    private void setHolidayUrl(String holidayUrl) {
//        HOLIDAY_URL = holidayUrl;
//    }
//
//    @Value("#{'${chjb.sftp.sftpReceivePath}'}")
//    public  void setSftpReceivePath(String sftpReceivePath) {
//        SFTP_RECEIVE_PATH = sftpReceivePath;
//    }
//
//    @Value("#{'${chjb.sftp.sftpGeneratePath}'}")
//    public  void setSftpGeneratePath(String sftpGeneratePath) {
//        SFTP_GENERATE_PATH = sftpGeneratePath;
//    }
//
//    @Value("${chjb.medicalInter.type}")
//    public void setMedicalInterType(String medicalInterType) {
//        MEDICAL_INTER_TYPE = medicalInterType;
//    }
//
//    @Value("${chjb.medicalInter.proUrl}")
//    public void setMedicalProUrl(String medicalProUrl) {
//        MEDICAL_PRO_URL = medicalProUrl;
//    }
//
//    @Value("${chjb.medicalInter.tesUrl}")
//    public void setMedicalTesUrl(String medicalTesUrl) {
//        MEDICAL_TES_URL = medicalTesUrl;
//    }
//
//    @Value("#{'${chjb.obs.obs-switch}'}")
//    public void setObsSwitch(String obsSwitch){
//        OBS_SWITCH = obsSwitch;
//    }
//
//    @Value("#{'${chjb.obs.obs-endpoint}'}")
//    public void setObsEndpoint(String obsEndpoint){
//        OBS_ENDPOINT = obsEndpoint;
//    }
//
//    @Value("#{'${chjb.obs.obs-ak}'}")
//    public void setObsAk(String obsAk){
//        OBS_AK = obsAk;
//    }
//
//    @Value("#{'${chjb.obs.obs-sk}'}")
//    public void setObsSk(String obsSk){
//        OBS_SK = obsSk;
//    }
//
//    @Value("#{'${chjb.obs.obs-bucket}'}")
//    public void setObsBucket(String obsBucket){
//        OBS_BUCKET = obsBucket;
//    }
//
//    @Value("#{'${chjb.obs.obs-image}'}")
//    public void setObsImage(String obsImage){
//        OBS_IMAGE = obsImage;
//    }
//
//    @Value("#{'${chjb.obs.obs-attach}'}")
//    public void setObsAttach(String obsAttach){
//        OBS_ATTACH = obsAttach;
//    }
//
//    @Value("#{'${chjb.obs.obs-video}'}")
//    public void setObsVideo(String obsVideo){
//        OBS_VIDEO = obsVideo;
//    }
//
//    @Value("#{'${chjb.obs.obs-audio}'}")
//    public void setObsAudio(String obsAudio){
//        OBS_AUDIO = obsAudio;
//    }
//
//    @Value("#{'${chjb.obs.obs-template}'}")
//    public void setObsTemplate(String obsTemplate){
//        OBS_TEMPLATE = obsTemplate;
//    }*/
}