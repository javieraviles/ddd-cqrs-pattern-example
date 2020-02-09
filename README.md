# ddd-cqrs-pattern-example

API REST docs

## GET ALL OPENED CLAIMS

* #### METHOD GET

* #### URI: http://localhost:8080/api/claim/

* #### RESPONSE
	```
	[
        {
            "id": 3,
            "lossDescription": "Garage flooded, every electrical appliance broken in there",
            "lossType": "ELECTRICAL_APPLIANCES",
            "status": "OPENED",
            "compensation": 900
        },
        {
            "id": 4,
            "lossDescription": "Living room window broken due to earthquake",
            "lossType": "WINDOWS",
            "status": "OPENED",
            "compensation": 320
        }
    ]
	```


## NEW POLICY

* #### METHOD POST

* #### URI:  http://localhost:8080/api/client/{clientId}/policy

* #### BODY
	```
	{
        "address": "Super hype street",
        "risk": 3,
        "electricalAppliancesCoverage": true,
        "windowsCoverage": false,
        "facadeCoverage": true,
        "startingDate": "2016-10-10T15:00:00",
        "yearlyPrice": 499
    }
	```


## NEW CLAIM

* #### METHOD POST

* #### URI:  http://localhost:8080/api/policy/{policyId}/claim

* #### BODY

	```
	{
        "lossDescription":"Garage flooded, every electrical appliance broken in there",
        "lossType": "ELECTRICAL_APPLIANCES",
        "creationDate": "2020-02-09T18:00:00",
        "compensation": 900
    }
	```
