#include <stdio.h>
#include "pico/stdlib.h"
#include "hardware/i2c.h"
#include "hardware/adc.h"
#include <stdbool.h>
#include <math.h> 

#define Configuration_register 0x00
#define Shunt_voltage_register 0x01
#define Bus_voltage_register 0x02
#define Power_register 0x03
#define Current_register 0x04
#define Calibration_register 0x05

#define SDA_pin 4
#define SDL_pin 5

#define INA219_ADDR 0x40

#define R_SHUNT 0.01

#define Battery_adc 26
#define Radio_adc 27
#define Lightbulb 28
#define CoolingFan 29

typedef Device{
    float voltage, optimal_temp, temperture, current;
    double soC, battery_percentage;
    int batCapacity, begOfLifeCapacity, device_gpio_pin;
    
}LightBulb, Radio, CeilingFan;

void turnOn(Device object){
    gpio_put(object.device_gpio_pin, 1);
}
void turnOff(){
    gpio_put(object.Device,0);
}
void poll_voltage()
{
    i2c_init();
    uint8_t current_data, power_data, shunt_voltage, bus_voltage;
    i2c_read_register(INA219_ADDR, Current_register, &current_data);
    i2c_read_register(INA219_ADDR, Power_register, &power_data);
    i2c_read_register(INA219_ADDR, Shunt_voltage_register, &shunt_voltage);
    i2c_read_register(INA219_ADDR, Bus_voltage_register, &bus_voltage);
}

float get_thermal_reading(Device object, int PWM_level)
{
    adc_gpio_init(device);
    adc_select_input(0);
    uint16_t reading=adc_read();
    float voltage= 3.3f*(reading/4095);
    float resistance=R_SHUNT*(reading/(3.3f-reading));
    float temp=(1/(1/25)+(1/3435)*log(resistance/0.1));
    gpio_set_function(object.device_gpio_pin, GPIO_FUNC_PWM);
    uint slice= pwm_gpio_to_slice_num(object.device_gpio_pin);
    while(1){
        if(object.temperture>object.optimal_temp){
            pwm_set_wrap(slice, PWM_level);
            pwm_set_chan_level(slice, PWM_CHAN_A, Power_register, PWM_level)
            PWM_level-=100;
            sleep_ms(1000);
            P
        }
    }
    return temp;

}
int main()
{
    stdio_init_all();
    adc_init();
    gpio_set_function(SDA_pin, GPIO_FUNC_I2C);
    gpio_set_function(SDL_pin, GPIO_FUNC_I2C);
    double expected_current = 600, calbration = expected_current / 32768;
    double real_calbration = 0.04096 / (calbration * R_SHUNT);
    uint8_t radio, fan, light;
    adc_init();
    adc_gpio_init(26); // Radio
    adc_gpio_init(27); // LightBulb
    adc_gpio_init(28); // CoolingFan
    if (expected_current < 1)
    {
        expected_current = 1d;
    }
    i2c_write_register(INA219_ADDR, Calibration_register, real_calbration);
    while (true)
    {
        printf("yooo");
        printf("Hello, world!\n");
        sleep_ms(1000);
    }
}