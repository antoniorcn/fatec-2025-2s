actual suspend fun provideDbDriver(
  schema: SqlSchema<QueryResult.AsyncValue<Unit>>
): SqlDriver {
  return JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    .also { schema.create(it).await() }
}