package br.com.zup.trinlha.apimarvel.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zup.trinlha.apimarvel.model.DataResponse;
import br.com.zup.trinlha.apimarvel.model.GeneralResponse;
import br.com.zup.trinlha.apimarvel.model.Result;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarvelServiceImplTests {

	private static final String TS_APIKEY_HASH = "?ts=1610630861257&apikey=de8ae6b7ddc90c4bbcaba79435515c1a&hash=836df4db56628210204181858618c0a6";

	@Autowired
	private MarvelServiceImpl service;

	@Test
	public void consumerTest() {

		GeneralResponse generalResponse = service.consumer(TS_APIKEY_HASH);
		DataResponse dataRespose = generalResponse.getData();
		
		System.out.println(generalResponse.getCopyright());
		System.out.println(generalResponse.getAttributionText());
		System.out.println(generalResponse.getAttributionHTML());

		assertEquals("© 2021 MARVEL", generalResponse.getCopyright());
		assertEquals("Data provided by Marvel. © 2021 MARVEL", generalResponse.getAttributionText());
		assertEquals("<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>",
				generalResponse.getAttributionHTML());

		List<Result> results = dataRespose.getResults();

		assertEquals(dataRespose.getResults(), results);
		
		assertEquals(Long.valueOf(82967), dataRespose.getResults().get(0).getId());
		assertEquals("Marvel Previews (2017)", dataRespose.getResults().get(0).getTitle());
		assertEquals("http://gateway.marvel.com/v1/public/comics/82967", dataRespose.getResults().get(0).getResourceURI());
		
		System.out.println(dataRespose.getResults().get(0).getId());
		System.out.println(dataRespose.getResults().get(0).getTitle());
		System.out.println(dataRespose.getResults().get(0).getResourceURI());

	}

}
