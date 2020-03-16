package ratel.sso.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Map;

/**
 * @author ratel
 * @date 2020/3/16
 */
public class JwtTokenUtil {
    /**
     * 加密算法
     **/
    private volatile static SignatureAlgorithm signatureAlgorithm;
    /**
     * 秘钥
     **/
    private volatile static SecretKeySpec secretKeySpec;

    /**
     * @param payLoad
     * @return java.lang.String
     * @Description 生成token
     * @Author ratel
     * @Date 2020/3/16
     **/
    public static String generatorToken(Map<String, Object> payLoad) {
        return Jwts.builder()
                .setPayload(JSON.toJSONString(payLoad))
                .signWith(getSignatureAlgorithm(), getSecretKeySpec())
                .compact();
    }

    /**
     * @Description 解析token
     * @Author      ratel
     * @Date        2020/3/16
     * @param       token
     * @return      io.jsonwebtoken.Claims
     **/
    public static Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(getSecretKeySpec()).parseClaimsJws(token).getBody();
    }

    private static SecretKeySpec getSecretKeySpec() {
        if (secretKeySpec != null) {
            return secretKeySpec;
        }
        synchronized (JwtTokenUtil.class) {
            if (secretKeySpec != null) {
                return secretKeySpec;
            }

        }
        //秘钥
        byte[] bytes = DatatypeConverter.parseBase64Binary("4ea88cecb57c4eeea8f382da613799a3");
        secretKeySpec = new SecretKeySpec(bytes, getSignatureAlgorithm().getJcaName());
        return secretKeySpec;
    }

    private static SignatureAlgorithm getSignatureAlgorithm(){
        if (signatureAlgorithm != null) {
            return signatureAlgorithm;
        }
        synchronized (JwtTokenUtil.class) {
            if (secretKeySpec != null) {
                return signatureAlgorithm;
            }
            //加密算法
            signatureAlgorithm = SignatureAlgorithm.ES256;
            return signatureAlgorithm;
        }
    }
}
