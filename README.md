# mohanydv-Weather--forcast-Api-using-RapidApi-Gloify
assigment of Weather forcast api for forcast detail by location name using 3rd party api RapidApi for gloify

# technology used
1) java 17
2) spring boot 3.1.7
3) okta = For authentication with random client id and random client secret and token genration

# to run the project
1) clone project from my repositoy(mohanydv)
2) build the project in you  sts Ide
3) run using Spring Boot

4) to genrate access token hit url => https://dev-54866022.okta.com/oauth2/default/v1/token
5) and in authurization header give 
6) cllient id (0oadhnqf6mFf1Aj4X5d7) as username and  client secrate(aIvVYHiTXJqe_RbOP4Vwf-lBMB8eqoPkNbJRquPKGqHd3rCba14oEK03xllDzM7E ) as password
7)  and in body give grant type and scope which are given in screenshot  

   
# ScreenShots for Refrence

## To genrate barier token with help of okta server  client id and random client secret

<img width="960" alt="for Token" src="https://github.com/mohanydv/mohanydv-Weather--forcast-Api-using-RapidApi-Gloify/assets/152065404/7255d806-f107-4694-8196-197e80d88296">

## call Get the Weather forecast  of Any city using API (RapidApiGetForecastSummaryByLocationName)
<img width="960" alt="apifor location" src="https://github.com/mohanydv/mohanydv-Weather--forcast-Api-using-RapidApi-Gloify/assets/152065404/2c311325-12ac-40be-9d25-4933b6193eec">

## Call Get hourly Weather forecast details of Any city using API (RapidApiGetHourlyForecastByLocationName)


<img width="960" alt="for hourly location" src="https://github.com/mohanydv/mohanydv-Weather--forcast-Api-using-RapidApi-Gloify/assets/152065404/9169203a-bdfa-47bb-86a7-a66583f4f5a7">

