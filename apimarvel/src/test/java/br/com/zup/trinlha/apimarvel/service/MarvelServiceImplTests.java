package br.com.zup.trinlha.apimarvel.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.zup.trinlha.apimarvel.model.ComicResponse;
import br.com.zup.trinlha.apimarvel.model.GeneralResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MarvelServiceImplTests {
	
	private static final String TS_APIKEY_HASH = "?ts=1610630861257&apikey=de8ae6b7ddc90c4bbcaba79435515c1a&hash=836df4db56628210204181858618c0a6";
	
	@Autowired
	private MarvelServiceImpl service;
	
	@Test
	public void consumerTest() {
		
		GeneralResponse generalResponse = service.consumer(TS_APIKEY_HASH);
		System.out.println(generalResponse);
		
		ComicResponse comicInfo = generalResponse.getData();
		
		assertEquals("© 2021 MARVEL", generalResponse.getCopyright());
		assertEquals("Data provided by Marvel. © 2021 MARVEL", generalResponse.getAttributionText());
		assertEquals("<a href=\"http://marvel.com\">Data provided by Marvel. © 2021 MARVEL</a>", generalResponse.getAttributionHTML());
		
		assertEquals(Long.valueOf(82967), comicInfo.getId());
		assertEquals("Marvel Previews (2017)", comicInfo.getTitle());
		assertEquals("http://gateway.marvel.com/v1/public/comics/82967", comicInfo.getResourceUri());
		
	}

}
