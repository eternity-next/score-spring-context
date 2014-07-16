package com.nhnnext.score.scores;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;

import com.google.gson.Gson;

public class HttpScoreRepository implements ScoreRepository {
	private String url;
	private HttpClient client;
	
	public HttpScoreRepository() {
		this.url = "http://localhost:3000/scores";
		this.client = new HttpClient(new MultiThreadedHttpConnectionManager());
	}
	
	public int [] getScores() {
		GetMethod get = new GetMethod(url);
		try {
			if (client.executeMethod(get) == HttpStatus.SC_OK) {
				return new Gson().fromJson(get.getResponseBodyAsString(), int [].class);
			} else {
				return new int [0];
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			get.releaseConnection();
		}
	}
}
