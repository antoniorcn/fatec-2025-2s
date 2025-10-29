actual suspend fun provideDbDriver(
  schema: SqlSchema<QueryResult.AsyncValue<Unit>>
): SqlDriver {
  return WebWorkerDriver(
    Worker(
      js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
    )
  ).also { schema.create(it).await() }
}