package com.hubix.apiconnector.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.hubix.apiconnector.crypto.Asset;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class RealTimeStockService {

    private static final Logger logger = Logger.getLogger("RealTimeStockService");
    public static final String bitMexIndicesData = "https://www.bitmex.com/api/v1/instrument/indices";
    private volatile boolean programRunning = true;

    public void runAnalysis(String rootSymbol) throws IOException {
        Scanner userInput = new Scanner(System.in);
        FileService fileService = new FileService();
        File file = fileService.getFile();
        System.out.println("Press any key to start program..");
        userInput.nextLine();

        Thread threadOne = new Thread(() -> {
            while(programRunning) {
                try {
                    getAssetData()
                            .stream()
                            .filter(i -> i.getRootSymbol().equals(rootSymbol))
                            .forEach(i -> {
                                System.out.println(i.getRootSymbol() + " " + i.getLastPrice());
                            });
                    System.out.println("Press any key to stop program");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadTwo = new Thread(() -> {
            userInput.nextLine();
            programRunning = false;
            System.out.println("Program stopping..");
            userInput.close();
        });

        threadOne.start();
        threadTwo.start();
    }

    private URLConnection connectToService(String bitMexIndicesData) throws IOException {
        URL url = new URL(bitMexIndicesData);
        URLConnection request = url.openConnection();
        request.connect();
        logger.info("Connection made");
        return request;
    }

    private JsonArray getJsonArray() throws IOException {
        JsonParser jsonParser = new JsonParser();
        JsonElement element = jsonParser.parse((new InputStreamReader((InputStream) connectToService(bitMexIndicesData).getContent())));
        return element.getAsJsonArray();
    }

    public List<Asset> getAssetData() throws IOException {
        List<Asset> assets = new ArrayList<>();
        for(JsonElement element : getJsonArray()) {
            assets.add(mapToAsset(element));
        }
        return assets;
    }

    private Asset mapToAsset(JsonElement element) {
        Asset asset = new Asset();
        asset.setSymbol(element.getAsJsonObject().get("symbol").getAsString());
        asset.setRootSymbol(element.getAsJsonObject().get("rootSymbol").getAsString());
        asset.setState(element.getAsJsonObject().get("state").getAsString());
        asset.setTyp(element.getAsJsonObject().get("typ").getAsString());
        asset.setQuoteCurrency(element.getAsJsonObject().get("quoteCurrency").getAsString());
        asset.setReference(element.getAsJsonObject().get("reference").getAsString());
        asset.setReferenceSymbol(element.getAsJsonObject().get("referenceSymbol").getAsString());
        asset.setPrevPrice24h(element.getAsJsonObject().get("prevPrice24h").getAsDouble());
        asset.setLastPrice(element.getAsJsonObject().get("lastPrice").getAsDouble());
        asset.setLastChangePcnt(element.getAsJsonObject().get("lastChangePcnt").getAsDouble());
        asset.setMarkPrice(element.getAsJsonObject().get("markPrice").getAsDouble());
        asset.setTimestamp(element.getAsJsonObject().get("timestamp").getAsString());
        return asset;
    }
}


