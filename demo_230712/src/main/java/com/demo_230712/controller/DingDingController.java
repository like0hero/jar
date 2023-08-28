package com.demo_230712.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.aliyun.tea.*;

@Controller
public class DingDingController {

    /**
     * 使用 Token 初始化账号Client
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dingtalkrobot_1_0.Client createClient() throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
        config.protocol = "https";
        config.regionId = "central";
        return new com.aliyun.dingtalkrobot_1_0.Client(config);
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dingtalkrobot_1_0.Client client = createClient();
        com.aliyun.dingtalkrobot_1_0.models.OrgGroupSendHeaders orgGroupSendHeaders = new com.aliyun.dingtalkrobot_1_0.models.OrgGroupSendHeaders();
        orgGroupSendHeaders.xAcsDingtalkAccessToken = "1eec25e98a4e36aeadfb1dcd6d6253a0";
        com.aliyun.dingtalkrobot_1_0.models.OrgGroupSendRequest orgGroupSendRequest = new com.aliyun.dingtalkrobot_1_0.models.OrgGroupSendRequest()
                .setMsgParam("{\"content\":\"钉钉，让进步发生\"}")
                .setMsgKey("sampleText")
                .setOpenConversationId("cidikd5aKmVOWDt860UQXYDog==")
                .setRobotCode("dingu7bdjpk4surxv4xb")
                .setCoolAppCode("");
        try {
            client.orgGroupSendWithOptions(orgGroupSendRequest, orgGroupSendHeaders, new com.aliyun.teautil.models.RuntimeOptions());
        } catch (TeaException err) {
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            if (!com.aliyun.teautil.Common.empty(err.code) && !com.aliyun.teautil.Common.empty(err.message)) {
                // err 中含有 code 和 message 属性，可帮助开发定位问题
            }

        }
    }
    /*@RequestMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(){
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("服务器已启动，等待客户端连接...");

            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接，IP地址：" + socket.getInetAddress());

            // 处理客户端请求
            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int i = in.read(bytes);
            String str = new String(bytes, 0, i);
            System.out.println("客户端消息：" + str);
            //4.返回数据给客户端。
            OutputStream out = socket.getOutputStream();
            out.write("我很好".getBytes());
            //5.关闭资源
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "tcp成功";
    }*/


}
