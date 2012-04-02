package com.mmm.spring.socsec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "UserConnection", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "userId", "providerId",
				"providerUserId" }),
		@UniqueConstraint(columnNames = { "userId", "providerId", "rank" }) })
public class User {
	/**
	 * A local identifier for the user, in our case the username.
	 */
	@Id
	private String userId;

	@Column(nullable = false)
	private String providerId;

	private String providerUserId;

	@Column(nullable = false)
	private int rank;

	private String displayName;

	private String profileUrl;

	private String imageUrl;

	@Column(nullable = false)
	private String accessToken;

	private String secret;

	private String refreshToken;
	private Long expireTime;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Long expireTime) {
		this.expireTime = expireTime;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", providerId="
				+ providerId + ", providerUserId=" + providerUserId + ", rank="
				+ rank + ", displayName=" + displayName + ", profileUrl="
				+ profileUrl + ", imageUrl=" + imageUrl + ", accessToken="
				+ accessToken + ", secret=" + secret + ", refreshToken="
				+ refreshToken + ", expireTime=" + expireTime + "]";
	}

}
