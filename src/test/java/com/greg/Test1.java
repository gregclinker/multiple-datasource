package com.greg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.greg.Application;
import com.greg.entity.Widget;
import com.greg.repository.WidgetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class Test1 {

	@Autowired
	private WidgetRepository repository;
	
	@Autowired
	private DataSource dataSource;

	@Test
	public void test1() {
		assertNotNull(dataSource);
		
		assertNotNull(repository);
		repository.save(makeWidget("widget1"));
		Widget widget = repository.findOne(1l);
		assertEquals(1l, widget.getId().longValue());
		assertEquals("widget1", widget.getDescription());
	}
	
	private Widget makeWidget(String description) {
		Widget widget = new Widget();
		widget.setDescription(description);
		return widget;
	}
	
	

}
