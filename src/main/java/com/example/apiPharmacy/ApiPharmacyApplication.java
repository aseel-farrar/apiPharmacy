package com.example.apiPharmacy;

import com.example.apiPharmacy.jasonToObjectModel.DrugApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;


@SpringBootApplication
public class ApiPharmacyApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DrugsService drugsService;

    public static void main(String[] args) {
        SpringApplication.run(ApiPharmacyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // get the drugs from the API and save it in database
        int numberOfHits = 5; //number of drugs = number of hits * 100
        for (int counter = 1; counter <= (numberOfHits * 95); ) {
            String url = "https://dailymed.nlm.nih.gov/dailymed/services/v2/drugnames.json?page=" + counter;
            getDrugsFromApi(url);
            counter += 95;
        }

        // create users for testing
        Users aseel = new Users("assel");
        userRepository.save(aseel);

        Users judy = new Users("judy");
        userRepository.save(judy);

        Users ahmad = new Users("ahmad");
        userRepository.save(ahmad);

        Users mohammad = new Users("mohammad");
        userRepository.save(mohammad);

        Users yousef = new Users("yousef");
        userRepository.save(yousef);

//        // assign drugs to users for testing
//        assignDrugToUser(3L, 8L);
//        assignDrugToUser(3L, 100L);
//        assignDrugToUser(4L, 33L);
//        assignDrugToUser(4L, 77L);
//        assignDrugToUser(5L, 100L);
//        assignDrugToUser(5L, 77L);
//        assignDrugToUser(2L, 8L);
//        assignDrugToUser(2L, 300L);
//        assignDrugToUser(1L, 33L);
//        assignDrugToUser(1L, 300L);
    }
// the following assignDrugToUser method here for testing
//    /**
//     * function to assign specific drug to specific user
//     * @param userId
//     * @param drugId
//     */
//    public void assignDrugToUser(Long userId, Long drugId){
//    Users user= userRepository.findUsersByUserId(userId);
//    Drug drug = drugsService.getDrug(drugId);
//    user.getDrugs().add(drug);
//    userRepository.save(user);
//}

    /**
     * function to get the drugs from the API
     *
     * @param url:
     * @throws: IOException
     */
    public void getDrugsFromApi(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setRequestMethod("GET");

        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();

        bufferedReader.close();

        Gson gson = new Gson();
        DrugApi drugApi = gson.fromJson(data, DrugApi.class);

        for (int index = 0; index < drugApi.getData().length; index++) {
            String drugName = drugApi.getData()[index].get("drug_name").toString();
            saveDrugInDB(drugName);
        }
    }

    /**
     * function to save the drug instance in the database
     *
     * @param drug instance
     */
    public void saveDrugInDB(String drug) {
        drugsService.addDrug(new Drug(drug));
    }
}
