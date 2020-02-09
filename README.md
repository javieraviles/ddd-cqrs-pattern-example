# cqrs-pattern-example

API REST docs

## GET ALL WAITING CLAIMS

* #### METHOD GET

* #### URI: http://localhost:8080/api/claim/

* #### RESPONSE
	```
	[
        {
            "id": 3,
            "lossDescription": "Garage flooded, every electrical appliance broken in there",
            "status": "WAITING",
            "compensation": 900
        },
        {
            "id": 4,
            "lossDescription": "Living room window broken due to earthquake",
            "status": "WAITING",
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
        "electricalAppliancesCover": true,
        "windowsCover": false,
        "facadeCover": true,
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
        "status": "WAITING",
        "creationDate": "2020-02-09T18:00:00",
        "compensation": 900
    }
	```
