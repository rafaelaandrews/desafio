package br.com.b2w.starwars.planets.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.b2w.starwars.planets.exception.ServiceException;

@Component
public class SwApiPlanetService {

	@Value("${swapi.url}")
	private String swapiUrl;

	public Integer getFilmAppearancesByName(String planetName) {

		HttpGet httpGetRequest = buildRequest(planetName);
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpResponse httpResponse = null;
		JsonObject jsonObject = null;

		try {
			httpResponse = httpClient.execute(httpGetRequest);

			validateHttpResponse(httpResponse);

			jsonObject = buildJsonObject(httpResponse);

		} catch (IOException ex) {
			new IOException(ex.getMessage());
		}

		return getNumberOfFilmAppearances(jsonObject);

	}

	private Integer getNumberOfFilmAppearances(JsonObject jsonObject) {
		Integer numberOfFilmAppearances = 0;

		if (jsonObject == null)
			return numberOfFilmAppearances;

		JsonArray results = jsonObject.getAsJsonArray("results");

		if (results.size() == 0) {
			return numberOfFilmAppearances;
		}

		JsonElement jsonElement = results.get(0);
		JsonObject result = jsonElement.getAsJsonObject();
		JsonArray films = result.getAsJsonArray("films");
		numberOfFilmAppearances = films.size();

		return numberOfFilmAppearances;
	}

	private HttpGet buildRequest(String planetName) {
		HttpGet httpGet = new HttpGet(swapiUrl + planetName);
		httpGet.addHeader("accept", "application/json");

		return httpGet;
	}

	private void validateHttpResponse(HttpResponse response) {
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new ServiceException("Failed: HTTP error: ", response.getStatusLine().getReasonPhrase(),
					response.getStatusLine().getStatusCode());
		}
	}

	private JsonObject buildJsonObject(HttpResponse response) {
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;

		try {
			bufferedReader = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		JsonObject jsonObject = deserialize(stringBuilder.toString());

		return jsonObject;
	}

	private JsonObject deserialize(String json) {
		Gson gson = new Gson();
		JsonObject jsonClass = gson.fromJson(json, JsonObject.class);
		return jsonClass;
	}

}
