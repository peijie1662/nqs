package nbct.com.cn.customerquery.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import nbct.com.cn.customerquery.config.ServerSecrity;
import nbct.com.cn.customerquery.entity.User;

/**
 * @author PJ
 * @version 创建时间：2019年7月7日 下午12:50:28
 */
@Service
public class TokenService {

	@Autowired
	ServerSecrity secrity;

	public String getToken(User user) {
		String key = secrity.getKey();
		long nowMillis = System.currentTimeMillis() + secrity.getExpireInterval();
		Date expireDate = new Date(nowMillis);
		String jwt = JWT.create().withExpiresAt(expireDate).withClaim("userId", user.getUserId())
				.withClaim("roleId", user.getRoleId()).withJWTId(UUID.randomUUID().toString())
				.sign(Algorithm.HMAC256(key));
		return jwt;
	}

}
