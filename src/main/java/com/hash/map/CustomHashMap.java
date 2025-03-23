package com.hash.map;

public class CustomHashMap<K, V> {

	Entry[] hashTable;
	int INITIAL_CAPACITY =4;
	int size = 0;

	public CustomHashMap() {
		hashTable = new Entry[INITIAL_CAPACITY];
	}

	private boolean put(K key, V value) {
		int hashCode = Math.abs(key.hashCode() % hashTable.length);
		if (hashTable[hashCode] == null) {
			hashTable[hashCode] = new Entry(key, value);
			return true;
		}
		//handle collision of hashCode
		Entry node = hashTable[hashCode];
		Entry previousNode = node;
		while (node != null) {
			if (node.key == key) {
				node.value = value;
				return true;
			}
			previousNode = node;
			node = node.next;
		}

		previousNode.next = new Entry(key, value);
		return true;
	}
	
	private V get(K key) {
		int hashCode=Math.abs(key.hashCode() % hashTable.length);
		Entry node=hashTable[hashCode];
		while(node!=null) {
			if(node.key==key)
				return (V)node.value;
			node=node.next;
		}
		return null;
	}
	
	public Entry[] getHashTable() {
		return hashTable;
	}

	public void setHashTable(Entry[] hashTable) {
		this.hashTable = hashTable;
	}

	public class Entry<K, V> {
		K key;
		V value;
		Entry next;

		public Entry(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		CustomHashMap<String, Integer> hashMap= new CustomHashMap<String, Integer>();
		hashMap.put("Yess", 1);
		hashMap.put("Yooo", 2);
		hashMap.put("yooo", 3);
		hashMap.put("yess", 4);
		hashMap.put("Abcd", 5);
		hashMap.put("abcd", 56);
		hashMap.put("ABCD", 9);
		hashMap.put("yNot", 646);
		hashMap.put("xyz", 7475);
		hashMap.put("abaabab", 74759);
		hashMap.put("jdnjew", 3425);
		
		System.out.println("Getting ->Yess " +hashMap.get("Yess"));
		System.out.println("Getting ->abcd " +hashMap.get("abcd"));
		System.out.println("Getting ->yNot " +hashMap.get("yNot"));
		System.out.println("Getting ->abaabab " +hashMap.get("abaabab"));
		System.out.println("Getting -> jdnjew" +hashMap.get("jdnjew"));
		
		
		System.out.println("Full entryMap ->");
		System.out.println("---------");
		for(CustomHashMap.Entry entry:hashMap.getHashTable()) {
			while(entry!=null) {
				System.out.print("entry key="+ entry.key + "   entry value=" + entry.value);
				entry=entry.next;
				System.out.println();
			}
			System.out.println("---------");
			
		}
		
	}

}
