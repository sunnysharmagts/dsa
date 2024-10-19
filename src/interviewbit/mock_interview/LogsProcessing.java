package interviewbit.mock_interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Imagine you have an RPC server that produces a log of entries and we're analyzing it offline. There are two entries for each call, one when the RPC starts and one when the RPC finishes processing. We'd like to know as soon as possible if there's an RPC that took too much time / timed out.

Timestamp, logid, requestid, natureoflog

Timeout = 5
0 jkl, 3, start
0, abc, 1, start
2, def, 2, start
3, efg, 1, end
10, ghi, 2, end
15, h, 3, end

Has there been any timeout?
Yes
What is the first id of the log statement when you can tell me that there has been a timeout?
efg
Id of the first request that got timed out?
3

 * @author sunnysharma
 *
 */

/**
 * SOLUTION
 * 
 * I realised that I had not asked questions in the beginning which was a basic mistake, I didn't knew the following :-
 * 
 *  1. Can there be a end record without a starting records.
 *  2. How would the method I/O look like. What would be the input provided and what would be the output expected ?
 *  3. The request would come as streams or full list.
 *  4. Didn't dry run the sample input to know how did the desired output came.
 *  5. Would the start request entry come always before end entry.
 *  5. The question is too open ended and could have changed into many folds.
 *  
 *  Approach
 *  
 *  Considering that each end request would have start entry request.
 *  
 *    1. Maintain an unordered map and store all the start request entries with requestID as key
 *    2. Maintain an double linked list to maintain the order of the request.
 *    3. As soon as you get a end request entry, calculate the diff to see if it exceeds the threshold
 *    4. If yes then store it in firstExpiredRequest.
 *    5. Return the firstExpiredRequest if present.
 *  
 * 
 * @author sunnysharma
 *
 */
public class LogsProcessing {
	
	private Map<Integer, LogLinkedList> map;
	
	private LogLinkedList head;
	private LogLinkedList tail;
	private int threshold;
	private LogLinkedList firstExpiredRequest;

	public static void main(String[] args) {
		var obj = new LogsProcessing();
		obj.init(5);
		obj.process(0, "jkl", 3, "start");
		obj.process(0, "abc", 1, "start");
		obj.process(2, "def", 2, "start");
		obj.process(10, "ghi", 2, "end");
		obj.process(3, "efg", 1, "end");
		obj.process(15, "klm", 3, "end");
		System.out.println(obj.getFirstExpiredLogID());
		System.out.println(obj.getFirstExpiredRequestID());
		
		obj = new LogsProcessing();
		obj.init(5);
		obj.process(0, "jkl", 3, "start");
		obj.process(0, "abc", 1, "start");
		obj.process(2, "def", 2, "start");
		obj.process(15, "klm", 3, "end");
		obj.process(10, "ghi", 2, "end");
		obj.process(3, "efg", 1, "end");
		System.out.println(obj.getFirstExpiredLogID());
		System.out.println(obj.getFirstExpiredRequestID());
	}
	
	public void init(int threshold) {
		map = new HashMap<Integer, LogLinkedList>();
		head = new LogLinkedList(null);
		tail = new LogLinkedList(null);
		head.next = tail;
		tail.prev= head;
		this.threshold = threshold;
	}
	
	public void process(int timestamp, String logID, int requestID, String requestNature) {
		final var log = new Log(timestamp, logID, requestID, requestNature);
		if(requestNature == "end") {
			logExitRequest(log);
		}
		else if(requestNature == "start") {
			logEntryRequest(log);
		}
	}
	
	/**
	 *Can there be multiple request with same ID - Assuming NO
	 * 
	 * 1. If head is null / empty then add it as the first request
	 * 2. If not then add it as the last request. 
	 * 
	 * @param log
	 */
	private void logEntryRequest(Log log) {
		var current = new LogLinkedList(log);
		if(head.next.current == null) {
			var nextNode = head.next;
			head.next = current;
			current.next = nextNode;
			current.prev = head;
			nextNode.prev = current;
		}
		else {
			var lastNode = tail.prev;
			current.prev = lastNode;
			lastNode.next = current;
			current.next = tail;
			tail.prev = current;
		}
		map.put(log.requestID, current);
	}

	/**
	 * 
	 * @param log
	 */
	private void logExitRequest(Log log) {
		if(!map.containsKey(log.requestID)) {
			return;
		}
		final var entryRequest = map.get(log.requestID);
		int diff = log.timestamp - entryRequest.current.timestamp;
		//remove that node;
		var prev = entryRequest.prev;
		var next = entryRequest.next;
		prev.next = next;
		next.prev = prev;		
		if(diff <= threshold) {
			map.remove(log.requestID);
		} else {
			entryRequest.current.diff = diff;
			entryRequest.current.requestNature = log.requestNature;
			
			//Note that node down to expiredRequest
			if(firstExpiredRequest == null) {
				firstExpiredRequest = entryRequest;
			}
			
//			// add the node to the head;
//			var nextNode = head.next;
//			head.next = entryRequest;
//			entryRequest.prev = head;
//			entryRequest.next = nextNode;
//			nextNode.prev = entryRequest;
		}
	}
	public int getFirstExpiredRequestID() {
		if(firstExpiredRequest == null) return -1;
		return firstExpiredRequest.current.requestID;
	}
	
	public String getFirstExpiredLogID() {
		if(firstExpiredRequest == null) return null;
		return firstExpiredRequest.current.logID;
	}
	
	static class Log {
		int timestamp;
		String logID;
		int requestID;
		String requestNature;
		int diff;
		
		public Log(int timestamp, String logID, int requestID, String requestNature) {
			this.timestamp = timestamp;
			this.logID = logID;
			this.requestID = requestID;
			this.requestNature = requestNature;
		}

		@Override
		public String toString() {
			return "Log [timestamp=" + timestamp + ", logID=" + logID + ", requestID=" + requestID + ", requestNature="
					+ requestNature + ", diff=" + diff + "]";
		}
	}
	
	static class LogLinkedList {
		Log current;
		LogLinkedList next;
		LogLinkedList prev;
		
		public LogLinkedList(Log current) {
			this.current = current;
		}
	}

}
