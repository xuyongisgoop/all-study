package com.xuyong.study.cuncurrent;

import java.util.concurrent.Callable;

public class QueryInfoTask implements Callable<QueryResult>{

	public QueryResult call() throws Exception {
		System.out.println("QueryInfoTask.call()");
		return new QueryResult("get info success");
	}

}
