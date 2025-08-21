package com.auctionweb.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//C-Branch

/*Technical objective: a REST api for an auction CRUD that stores groups of cattle from each
farm that offers/shows them.

Login: anyone can see the page and the cattle/farms, but to upload your cattle and to be part
of the auctions, it is necessary to be registrated and logged in.

Endpoints:
-Home: welcome to website, some words about the function of the website, then, some links
	to the other URLs.
-Cattle groups: will display a list of cattle offerings from different farms, in a Json format.
-Farms profiles: a page that displays the data from its farm in Json format, like: name, antiquity, overall quality of 
cattle (an improvised calculation from its cattle average frame, headWidth, hipWidth, bodyDepth and bodyLength), etc.

Main objective of the program: a place where farms of the zone can log to see other farm cattle, submit their 
own cattle with its characteristics and take place in an auction organized by the website's owner
if not, the site stays as a showcase of the cattle from other farms online and for visitors to see*/


@SpringBootApplication
public class AuctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);
	}
}
