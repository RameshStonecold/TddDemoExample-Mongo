/*
package com.example.tddexamples

import io.vavr.control.Either
import java.time.*
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

class LocalDateDateTimeTest {


    fun dateTimeFromString(dateTimeString: String): Either<Exception, LocalDateTime> {
        val dateTime = convertDateTime(dateTimeString)
        if (dateTime.isRight) {
            return dateTime
        } else {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            return this.convertDateTime(dateTimeString, formatter)
        }
    }

    fun yearMonthFromString(dateTimeString: String): Either<Exception, YearMonth> {

        val yearMonth = this.convertDateTime(dateTimeString)
        if (yearMonth.isRight) {
            return Either.right(YearMonth.from(yearMonth.get()))
        } else {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM")
            val year = convertYearMonth(dateTimeString, formatter)
            if (year.isRight) {
                return year
            } else {
                val formatter1 = DateTimeFormatter.ofPattern("MMM-yyyy")
                return convertYearMonth(dateTimeString, formatter1)
            }
        }
    }

    fun dateFromString(dateTimeString: String): Either<Exception, LocalDate> {
        val localDateTimeEither = convertDateTime(dateTimeString)
        return if (localDateTimeEither.isRight) {
            Either.right(localDateTimeEither.get().toLocalDate())
        } else {
            convertDate(dateTimeString)
        }

    }

    fun timeFromString(time: String): Either<Exception, LocalTime> {
        val localDateTimeEither = convertDateTime(time)
        if (localDateTimeEither.isRight) {
            return Either.right(localDateTimeEither.get().toLocalTime())
        } else {
            val convertTimeWithZone = convertTime(time)
            return if (convertTimeWithZone.isRight) {
                convertTimeWithZone
            } else {
                convertTimeWithOutZone(time)
            }

        }
    }

    private fun convertDateTime(dateTimeString: String): Either<Exception, LocalDateTime> {

        val dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME

        return this.convertDateTime(dateTimeString, dateTimeFormatter).
                map(Function<LocalDateTime, LocalDateTime> { this.getLocalDateTimeInIST(it) })

    }

    private fun convertTime(time: LocalTime): Either<Exception, LocalTime> {
        val localDateTime = LocalDateTime.of(LocalDate.now(), time)
        return Either.right(getLocalDateTimeInIST(localDateTime).toLocalTime())

    }

    private fun convertTime(time: String): Either<Exception, LocalTime> {
        val dateFormatter = DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .appendOffsetId()
                .optionalStart()
                .appendLiteral('[')
                .parseCaseSensitive()
                .appendZoneRegionId()
                .appendLiteral(']').toFormatter()
        val `fun` = { a: String, b: DateTimeFormatter ->
            LocalDateTime.of(LocalDate.now(),
                    LocalTime.parse(a, b))
        }
        return exceptionHandler(`fun`.andThen<LocalTime> { x -> this.getLocalDateTimeInIST(x).toLocalTime() },
                time, dateFormatter)

    }

    private fun convertTimeWithOutZone(time: String): Either<Exception, LocalTime> {
        val dateFormatter = DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .toFormatter()
        return exceptionHandler({ a, b ->
            LocalDateTime.of(LocalDate.now(),
                    LocalTime.parse(a, b)).toLocalTime()
        },
                time, dateFormatter)
    }

    private fun convertDate(date: String): Either<Exception, LocalDate> {
        val dateFormatter = DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .optionalStart()
                .appendOffsetId()
                .optionalStart()
                .appendLiteral('[')
                .parseCaseSensitive()
                .appendZoneRegionId()
                .appendLiteral(']').toFormatter()
        return exceptionHandler({ a, b ->
            LocalDateTime.of(LocalDate.parse(a, b),
                    LocalTime.of(0, 0, 0)).toLocalDate()
        }, date, dateFormatter)

    }

    private fun convertDateTime(dateTimeString: String,
                                dateTimeFormatter: DateTimeFormatter): Either<Exception, LocalDateTime> {

        return exceptionHandler(Function2<String, DateTimeFormatter, LocalDateTime> { text, formatter -> LocalDateTime.parse(text, formatter) },
                dateTimeString, dateTimeFormatter)


    }

    private fun getLocalDateTimeInIST(localDateTime: LocalDateTime): LocalDateTime {
        val zonedDateTime = ZonedDateTime.of(localDateTime,
                ZoneId.of("Asia/Calcutta"))

        return localDateTime.plusSeconds(zonedDateTime.offset.totalSeconds.toLong())
    }

    private fun convertYearMonth(dateTimeString: String,
                                 dateTimeFormatter: DateTimeFormatter): Either<Exception, YearMonth> {

        return exceptionHandler(Function2<String, DateTimeFormatter, YearMonth> { text, formatter -> YearMonth.parse(text, formatter) },
                dateTimeString, dateTimeFormatter)


    }

    private fun <T, R> exceptionHandler(function: java.util.function.Function<T, R>, t: T): Either<Exception, R> {
        try {
            return Either.right(function.apply(t))
        } catch (e: Exception) {
            return Either.left(e)
        }

    }

    private fun <T1, T2, R> exceptionHandler(function: io.vavr.Function2<T1, T2, R>,
                                             t1: T1,
                                             t2: T2): Either<Exception, R> {
        try {
            return Either.right(function.apply(t1, t2))
        } catch (e: Exception) {
            return Either.left(e)
        }

    }

        @Test
    fun localDateTimeCheck()
    {
        val DATE_FORMAT = "dd-M-yyyy hh:mm:ss a z"

        val formatter = DateTimeFormatter.ofPattern(DATE_FORMAT)

        val fromTimeZone = ZoneId.of("Asia/Kolkata")    //Source timezone
        val fromMongoTimeZone=ZoneId.of("Europe/Paris")
        val toTimeZone = ZoneId.of("America/New_York")  //Target timezone

        val today = LocalDateTime.now()          //Current time

        //Zoned date time at source timezone
        val currentISTime = today.atZone(fromTimeZone)

        //Zoned date time at target timezone
        val currentETime = currentISTime.withZoneSameInstant(toTimeZone)

        //Zoned date time at london timezone
        val currentUTC=currentISTime.withZoneSameInstant(fromMongoTimeZone)

        //Format date time - optional
        println("Indian Time Zone :  " + formatter.format(currentISTime))
        println("Us  Time   Zone  :  " + formatter.format(currentETime))
        println("London Time Zone :  "+formatter.format(currentUTC))

        val localDateTimeIST=formatter.format(currentISTime)

        println("Indian time : "+currentUTC.toLocalDateTime())
    }

}*/
