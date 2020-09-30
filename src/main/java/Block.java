import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Block {
	private List transactions = new ArrayList<Transaction>();
	private String prev_hash, hash;
	private int height, transactionCount;
	private Date when;

	public String getPrev_hash() {
		return prev_hash;
	}

	public String getHash() {
		return hash;
	}

	public int getHeight() {
		return height;
	}

	public int getTransactionCount() {
		return transactionCount;
	}

	public Block() {
		this.transactionCount = 0;
		this.when = new Date();
		this.height = 1;
		this.hash = "";
		this.prev_hash = "";
	}

	public Block(Block previousBlock) {
		this();
		this.prev_hash = previousBlock.hash;
		this.height = previousBlock.height + 1;
	}

	public void add_transaction(Transaction tx) {
		this.transactions.add(tx);
		this.transactionCount++;
	}

	public void finalizeBlock() {
		if (this.hash.isEmpty()) {
			this.hash = hashBlock();
		} else {
			throw new IllegalArgumentException("Block is already finalized");
		}
	}

	
	private String hashTransactions() {
		
		/*
		 * TODO: Implement this.
		 * 1. Iterate over all transactions.
		 * 2. Calculate the hash as curr_hash = hash(curr_hash + curr_txn)
		 */
		
		String currentHash = "";
		
		for (Iterator txn = transactions.iterator(); txn.hasNext(); ) {
			
			Transaction curr_txn = (Transaction) txn.next();
			
			// TODO : Calculate hash of transaction
			
						
						
		}
		
		
		return currentHash;

	}

	
	private String hashBlock() {
		
		/*
		 * TODO: Implement the hash block.
		 * 1. Get the transaction hash.
		 * 2. Assemble the blockheader:
		 *    blockheader = {
		 *        payload_hash,
		 *        timestamp,
		 *        prev_hash,
		 *        total_transactions
		 *    }
		 *    and encode it into a string.
		 * 3. Calculate the blockhash = hash(blockheader).
		 */
		
		String blockHash = "HASH";
		
		String transactionHash = this.hashTransactions();
		
		return blockHash;
		
		
	}
		
		



	
	public boolean validate() {
		/*
		 * TODO: Implement this.
		 * Check if the hash of the block is correct.
		 */
		
		return false;
		
		

	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public static Block blockFromJson(String json)  {
		Gson gson = new Gson();
		return gson.fromJson(json, Block.class);
	}
}
