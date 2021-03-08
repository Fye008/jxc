package com.atguigu.jxc;

import com.atguigu.jxc.vo.GoodsVo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JxcApplicationTests {

	@Test
	public void contextLoads() {

		Gson gson = new Gson();
		String str = "supplierId=4&amountPayable=504&amountPaid=504&purchaseDate=2021-03-08&remarks=&state=1&purchaseListGoodsStr=%5B%7B%22goodsId%22%3A33%2C%22goodsTypeId%22%3A6%2C%22goodsCode%22%3A%220024%22%2C%22goodsName%22%3A%22%E5%8D%93%E5%9B%BE%E5%A5%B3%E8%A3%85%E7%AB%8B%E9%A2%86%E9%92%88%E7%BB%87%E6%A0%BC%E5%AD%90%E5%8D%B0%E8%8A%B1%E6%8B%BC%E6%8E%A5%E9%AB%98%E8%85%B0A%E5%AD%97%E8%A3%992017%E7%A7%8B%E5%86%AC%E6%96%B0%E6%AC%BE%E7%A2%8E%E8%8A%B1%E8%BF%9E%E8%A1%A3%E8%A3%99%22%2C%22goodsModel%22%3A%22A%E5%AD%97%E8%A3%99%22%2C%22goodsUnit%22%3A%22%E4%BB%B6%22%2C%22lastPurchasingPrice%22%3A168%2C%22price%22%3A%22168%22%2C%22goodsNum%22%3A%223%22%2C%22total%22%3A504%7D%5D";

		gson.fromJson("supplierId=4&amountPayable=504&amountPaid=504&purchaseDate=2021-03-08", new TypeToken<List<GoodsVo>>() {}.getType());

	}

}
