package com.lesha.criminalintent.data.mapper

import com.lesha.criminalintent.data.model.CrimeEntity
import com.lesha.criminalintent.domain.model.Crime

class CrimeEntityMapper {
    fun toCrime(crimeEntity: CrimeEntity): Crime {
        return Crime(
            crimeEntity.id,
            crimeEntity.title,
            crimeEntity.date,
            crimeEntity.isSolved
        )
    }

    fun toCrimeEntity(crime: Crime): CrimeEntity {
        return CrimeEntity(
            crime.id,
            crime.title,
            crime.date,
            crime.isSolved
        )
    }
}