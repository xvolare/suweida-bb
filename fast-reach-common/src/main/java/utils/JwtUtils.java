package utils;

import constant.business.BusinessLoginConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     * @param ttlMillis jwt过期时间(毫秒)
     * @param claims    设置的信息
     * @return
     */
    public static String generateJwt(Map<String,Object>claims,Long ttlMillis){
        String jwt=Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, BusinessLoginConstant.SECRET_KEY)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+ttlMillis))
                .compact();
        return jwt;
    }

    /**
     * Token解密
     * @param token 加密后的token
     * @return
     */
    public static Claims parseJWT(String token) {
       Claims claims=Jwts.parser()
               .setSigningKey(BusinessLoginConstant.SECRET_KEY)
               .parseClaimsJws(token)
               .getBody();
        return claims;
    }

}
