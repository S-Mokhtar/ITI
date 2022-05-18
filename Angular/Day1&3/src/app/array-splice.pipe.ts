import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'arraySplice'
})
export class ArraySplicePipe implements PipeTransform {

  transform(value: string[], filter:string): string[] {
    return value.filter(s => s.includes(filter));
  }

}
