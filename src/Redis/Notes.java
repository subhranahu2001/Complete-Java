package Redis;

public class Notes {

    public static void main(String[] args) {

        // ==================== REDIS NOTES ====================

        // ===== TOPIC 1: What is Redis? =====
        // Redis = Remote Dictionary Server
        // - In-memory key-value data store (like a giant HashMap on a server)
        // - Stores data in RAM -> extremely fast (microseconds)
        // - Used by: Twitter, GitHub, Instagram, StackOverflow

        // ===== TOPIC 2: Redis vs Traditional Database =====
        // MySQL (Disk-based)          | Redis (Memory-based)
        // Stores data on hard disk    | Stores data in RAM
        // Slower reads/writes         | Blazing fast
        // Good for permanent data     | Good for temporary/frequent data
        // Note: Redis is NOT a replacement for DB, it works alongside DB

        // ===== TOPIC 3: When to Use Redis? =====
        // 1. Caching         - store frequently accessed data (e.g., user profile)
        // 2. Session Mgmt    - store login sessions
        // 3. Rate Limiting   - limit API calls per user
        // 4. Leaderboards    - real-time ranking (games)
        // 5. Message Queues  - pub/sub messaging

        // ===== TOPIC 4: Real-life Analogy =====
        // Library analogy:
        //   Bookshelf (going every time) = MySQL
        //   Books on your desk (quick access) = Redis

    }
}
